import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { ApiClientService } from '../api-client.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  

  constructor(private service: ApiClientService) { }

   login(f: NgForm) {
   console.log(f);
   let username: string = f.value.username;
   let password: string = f.value.password;
  this.service.login(username, password).subscribe((data) => {
    console.log(data);
  })
 }

  ngOnInit() {
  }

}
