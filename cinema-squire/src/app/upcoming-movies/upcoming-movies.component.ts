import { Component, OnInit } from '@angular/core';
import { ApiClientService } from '../api-client.service';

@Component({
  selector: 'app-upcoming-movies',
  templateUrl: './upcoming-movies.component.html',
  styleUrls: ['./upcoming-movies.component.css']
})
export class UpcomingMoviesComponent implements OnInit {

  constructor(private service: ApiClientService) { }

  movies: any;

  ngOnInit() {
    this.service.getUpcomingMovies().subscribe((data) => {
      this.movies = data;
      console.log(this.movies);
    })
  }

}
