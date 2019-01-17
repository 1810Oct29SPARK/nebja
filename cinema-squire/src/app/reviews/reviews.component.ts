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
    let rating: string = form.value.rating;
    let review: string = form.value.reviewText;
    let userId: string = this.user.userid;
    this.service.submitReview(rating, review, this.dataService.getMovieId(), userId).subscribe((data) => {
      console.log(data);
    })
    this.service.getReviewsByMovieId(this.dataService.getMovieId()).subscribe((data) => {
      this.reviews = data;
      console.log(data);
    })
  }

  ngOnInit() {
    this.service.searchMovieById(this.dataService.getMovieId()).subscribe((data) => {
      this.movie = data;
      console.log(this.movie);
      this.service.getReviewsByMovieId(this.dataService.getMovieId()).subscribe((data) => {
        this.reviews = data;
        console.log(data);
      })
    });
    this.user = this.dataService.getUser();
    
  }

}
