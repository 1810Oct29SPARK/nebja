import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { ApiClientService } from '../api-client.service';
import { Router } from '@angular/router';
import { DataServiceService } from '../data-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  user: any;

  constructor(private service: ApiClientService, private router: Router, private dataService: DataServiceService) { }

   login(f: NgForm) {
   console.log(f);
   let username: string = f.value.username;
   let password: string = f.value.password;
  this.service.login(username, password).subscribe((data) => {
    console.log(data);
    if (data != null) {
      this.dataService.setUser(data);
      this.router.navigateByUrl('/profile');
    } else {
      alert("invalid credentials");
    }
  })
 }

  ngOnInit() {
    this.user = this.dataService.getUser();
  }

}
