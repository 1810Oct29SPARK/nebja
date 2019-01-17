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
  selectedFile: File;
  reviews: any;
  movies: any = [];

  onFileChanged(event) {
    this.selectedFile = event.target.files[0]
  }


  uploadPhoto() {
    this.service.uploadPhoto(this.selectedFile, this.user.userid).subscribe((data) => {
      console.log(data);
    })
  }

  ngOnInit() {
    this.user = this.dataService.getUser();
    if (this.user == null) {
      this.router.navigateByUrl('/');
    }
    console.log(this.user);
    this.service.getReviewsByUserId(this.user.userid).subscribe((data) => {
      console.log(data);
      this.reviews = data;
      for (let i = 0; i < this.reviews.length; i++) {
        this.service.searchMovieById(this.reviews[i][4]).subscribe((d) => {
          console.log(d);
          this.movies.push(d);
          console.log(this.movies);
        });
      }

    });
    this.service.getWatchlist(this.user.userid).subscribe((data) => {
      console.log(data);
    })
  }

}
