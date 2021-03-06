import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { ApiClientService } from '../api-client.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ReviewsComponent } from '../reviews/reviews.component';

@Component({
  selector: 'app-profile-information',
  templateUrl: './profile-information.component.html',
  styleUrls: ['./profile-information.component.scss']
})
export class ProfileInformationComponent implements OnInit {

  constructor(private dataService: DataServiceService, private router: Router, private service: ApiClientService) { }

  user: any;
  watchlistItems: any = [];
  watchlist: any;
  selectedFile: File;
  reviews: any;
  movies: any = [];
  rToggle: boolean = false;
  wToggle: boolean = false;

  reviewToggle(){
    this.rToggle = !this.rToggle;
  }

  watchlistToggle() {
    this.wToggle = !this.wToggle;
  }

  deleteFromWatchlist(id) {
    this.service.deleteFromWatchlist(id).subscribe((data) => {
    });
  }

  onFileChanged(event) {
    this.selectedFile = event.target.files[0]
  }


  uploadPhoto() {
    this.service.uploadPhoto(this.selectedFile, this.user.userid).subscribe((data) => {
    })
  }

  ngOnInit() {
    this.user = this.dataService.getUser();
    if (this.user == null) {
      this.router.navigateByUrl('/');
    }
    this.service.getReviewsByUserId(this.user.userid).subscribe((data) => {
      this.reviews = data;
      for (let i = 0; i < this.reviews.length; i++) {
        this.service.searchMovieById(this.reviews[i][4]).subscribe((d) => {
          this.movies.push(d);
        });
      }

    });
    this.service.getWatchlist(this.user.userid).subscribe((data) => {
      this.watchlist = data;
      for (let i = 0; i < this.watchlist.length; i++) {
        this.service.searchMovieById(this.watchlist[i].movieids).subscribe((response) => {
          this.watchlistItems.push(response);
        });
      }
    })
  }

}
