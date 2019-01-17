import { Component, OnInit } from '@angular/core';
import { ApiClientService } from '../api-client.service';
import { DataServiceService } from '../data-service.service';

@Component({
  selector: 'app-upcoming-movies',
  templateUrl: './upcoming-movies.component.html',
  styleUrls: ['./upcoming-movies.component.css']
})
export class UpcomingMoviesComponent implements OnInit {

  constructor(private service: ApiClientService, private dataService: DataServiceService) { }

  movies: any;

  getMovie(id) {
    this.dataService.setMovieId(id);
    this.service.searchMovieById(id).subscribe((data) => {
    })
  }

  ngOnInit() {
    this.service.getUpcomingMovies().subscribe((data) => {
      this.movies = data;
    })
  }

}
