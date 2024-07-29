import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  id: any;
  user: User = new User();
  data: any;

  constructor(private service: UserRegistrationService,
    private route: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
  
      this.service.getUserById(this.id).subscribe(data => {
        this.user = data;
      }, error => console.log(error));
    }

  onSubmit(){
    this.service.updateUser(this.id,this.user).subscribe( data =>{
      this.goToUserList();
    }
    , error => console.log(error));
  }

  goToUserList(){
    this.router.navigate(['/search']);
  }
}
