import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http:HttpClient) { }

  public doRegisteration(user: User) {
    return  this.http.post("http://localhost:9001/users/",user,{responseType:'text' as 'json'})
  }

  public getUsers(){
    return this.http.get("http://localhost:9001/users/")
  }

  public deleteUser(id: number){
    return this.http.delete("http://localhost:9001/users/"+id)
  }

  public getUserById(id: number){
    return this.http.get("http://localhost:9001/users/"+id)
  }

  public updateUser(id: number, user: User) {
    return this.http.put("http://localhost:9001/users/"+id,user,{responseType:'text' as 'json'});
  }
}
