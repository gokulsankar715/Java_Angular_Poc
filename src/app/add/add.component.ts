import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserRegistrationService } from '../user-registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  user: User = new User;
  message:any;

  constructor(private service:UserRegistrationService,
    private router: Router) { }

  ngOnInit() {
  }
  public registerNow(){
    let response = this.service.doRegisteration(this.user);
    response.subscribe((data)=>this.message =data);
    this.router.navigate(['search']);
  }

}
""