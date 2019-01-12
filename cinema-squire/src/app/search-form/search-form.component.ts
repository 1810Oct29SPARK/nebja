import { Component, OnInit } from '@angular/core';
import { ApiClientService } from '../api-client.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  constructor(private service: ApiClientService) { }

  searchMovies(movie: NgForm) {
    this.service.searchMovie(movie.value.movie).subscribe((data) => {
      console.log(data);
    })
  }

  ngOnInit() {
  }

}
