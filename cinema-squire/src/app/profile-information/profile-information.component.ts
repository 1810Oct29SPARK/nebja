import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { ApiClientService } from '../api-client.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-profile-information',
  templateUrl: './profile-information.component.html',
  styleUrls: ['./profile-information.component.css']
})
export class ProfileInformationComponent implements OnInit {

  constructor(private dataService: DataServiceService, private service: ApiClientService) { }

  user: any;

  uploadPhoto(f: NgForm) {
    console.log(f);
  }

  ngOnInit() {
    this.user = this.dataService.getUser();
    console.log(this.user);
  }

}
