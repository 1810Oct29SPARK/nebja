import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DataServiceService } from '../data-service.service';
import { ApiClientService } from '../api-client.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.scss']
})
export class ReviewsComponent implements OnInit {

  movie: any;

  reviews: any;

  user: any;

  constructor(private dataService: DataServiceService, private service: ApiClientService) { }

  submitReview(form: NgForm){
    this.service.submitReview(form.value.rating, form.value.reviewText, this.user.userid);
    this.reviews = this.service.getReviewsByMovieId(this.movie.id);
  }

  ngOnInit() {
    this.service.searchMovieById(this.dataService.getMovieId()).subscribe((data) => {
      this.movie = data;
    })
    this.user = this.dataService.getUser();
    this.reviews = this.service.getReviewsByMovieId(this.movie.id);
  }

}
