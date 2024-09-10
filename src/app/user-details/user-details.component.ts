import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  id: any;
  user: User = new User;
  constructor(private route: ActivatedRoute, private router:Router,
     private service: UserRegistrationService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.user = new User();
    this.service.getUserById(this.id).subscribe( data => {
      this.user = data;
    });
  }

  public backToList(){
    this.router.navigate(['search']);
  }
}
