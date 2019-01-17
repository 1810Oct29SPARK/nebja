import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { ApiClientService } from '../api-client.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-information',
  templateUrl: './profile-information.component.html',
  styleUrls: ['./profile-information.component.css']
})
export class ProfileInformationComponent implements OnInit {

  constructor(private dataService: DataServiceService, private router: Router, private service: ApiClientService) { }

  user: any;

  uploadPhoto(f: NgForm) {
    console.log(f);
    this.service.uploadPhoto(f.value.picture, this.user.userid).subscribe((data) => {
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
    })
  }

}
