import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';
import { dashCaseToCamelCase } from '@angular/compiler/src/util';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent implements OnInit {

  users:any;
  constructor(private service:UserRegistrationService,
    private changeDetectorRef: ChangeDetectorRef,
    private router: Router) { }

  public delteUser(id:number){
    let resp= this.service.deleteUser(id);
    resp.subscribe();
    location.reload();
  
   }

   public getUserById(id:number){
    this.router.navigate(['user-details', id]);
   }

   public updateUser(id:number){
    this.router.navigate(['update-user', id]);
   }
   
  ngOnInit(){
    let response = this.service.getUsers();
    response.subscribe((data)=>this.users=data);
  }

  ngAfterViewChecked() {
    this.changeDetectorRef.detectChanges();
  }

}
