import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './add/add.component';
import { SearchDeleteComponent } from './search-delete/search-delete.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UpdateUserComponent } from './update-user/update-user.component';

const routes: Routes = [
  {path:"",redirectTo:"search",pathMatch:"full"},
  {path:"register",component:AddComponent},
  {path:"search",component:SearchDeleteComponent},
  {path:'user-details/:id', component: UserDetailsComponent},
  {path:'update-user/:id', component: UpdateUserComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
