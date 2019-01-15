import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DataServiceService } from '../data-service.service';
import { ApiClientService } from '../api-client.service';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.scss']
})
export class ReviewsComponent implements OnInit {

  movie: any;

  constructor(private dataService: DataServiceService, private service: ApiClientService) { }

  ngOnInit() {
    this.service.searchMovieById(this.dataService.getMovieId()).subscribe((data) => {
      this.movie = data;
    })
  }

}
