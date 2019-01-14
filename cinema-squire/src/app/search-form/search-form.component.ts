import { Component, OnInit } from '@angular/core';
import { ApiClientService } from '../api-client.service';
import { NgForm } from '@angular/forms';
import { DataServiceService } from '../data-service.service';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  loaded = false;

  movieResults: any;

  constructor(private service: ApiClientService, private dataService: DataServiceService) { }

  searchMovies(movie: NgForm) {
    this.service.searchMovie(movie.value.movie).subscribe((data) => {
      this.movieResults = data;
      console.log(this.movieResults);
    })
  }

  someFunction(id) {
    this.dataService.setMovieId(id);
    this.loaded = true;
    this.service.searchMovieById(id).subscribe((data) => {
      console.log(data);
    })
  }

  ngOnInit() {
  }

}
