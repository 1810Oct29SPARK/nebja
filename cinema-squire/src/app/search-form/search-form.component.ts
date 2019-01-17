import { Component, OnInit, ViewChild } from '@angular/core';
import { ApiClientService } from '../api-client.service';
import { NgForm } from '@angular/forms';
import { DataServiceService } from '../data-service.service';
import { ModalDirective } from 'angular-bootstrap-md';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  user: any;

  movieResults: any;

  constructor(private service: ApiClientService, private dataService: DataServiceService) { }

  @ViewChild('demoBasic') demoBasic: ModalDirective;

  showAndHideModal() {
    this.demoBasic.show();

    setTimeout(() => {
      this.demoBasic.hide();
    }, 1000);
  }

  searchMovies(movie: NgForm) {
    this.service.searchMovie(movie.value.movie).subscribe((data) => {
      this.movieResults = data;
      console.log(this.movieResults);
    })
  }

  addToWatchlist(id) {
    this.service.addToWatchlist(id, this.user.userid).subscribe((data) => {
      console.log(data);
      this.showAndHideModal();
    })
  }

  getMovie(id) {
    this.dataService.setMovieId(id);
    this.service.searchMovieById(id).subscribe((data) => {
      console.log(data);
    })
  }

  ngOnInit() {
    this.user = this.dataService.getUser();
  }

}
