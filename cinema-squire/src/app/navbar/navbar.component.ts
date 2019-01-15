import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApiClientService } from '../api-client.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {


 
  // searchMovies(movie: NgForm) {
  //   this.service.searchMovie(movie.value.movie).subscribe((data) => {
  //     this.movieResults = data;
  //     console.log(this.movieResults);
  //   })
  // }
  
  constructor(private service: ApiClientService) { }

  newAccount(form: NgForm) {
    this.service.createAccount(form.value.Username, form.value.Password, form.value.Profile).subscribe((data) => {
      console.log(data);
    })
  }
  ngOnInit() {
  }

}
