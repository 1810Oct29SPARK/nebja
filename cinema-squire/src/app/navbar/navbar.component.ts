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
    if (data != null) {
      this.dataService.setUser(data);
      this.router.navigateByUrl('/redirect');
    } else {
      alert("invalid credentials");
    }
  })
 }

 logout() {
   this.dataService.setUser(null);
   this.router.navigateByUrl('/redirect');
 }

 
  // searchMovies(movie: NgForm) {
  //   this.service.searchMovie(movie.value.movie).subscribe((data) => {
  //     this.movieResults = data;
  //     console.log(this.movieResults);
  //   })
  // }
  

  newAccount(form: NgForm) {
    this.service.createAccount(form.value.Username, form.value.Password, form.value.Profile).subscribe((data) => {
    })
  }
  ngOnInit() {
    this.user = this.dataService.getUser();
  }

}
