import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApiClientService } from '../api-client.service';
import { DataServiceService } from '../data-service.service'

@Component({
  selector: 'app-moderator',
  templateUrl: './moderator.component.html',
  styleUrls: ['./moderator.component.scss']
})
export class ModeratorComponent implements OnInit {
  users: any;
  img: any;

  constructor(private dataService: DataServiceService, private service: ApiClientService) { }

  userSearch(form: NgForm) {
    this.service.getAllUsers().subscribe((data) => {
      this.users = data;
      console.log(data)
    })
  }

  replaceUserImg() {
    console.log("replaceUserImg() triggered!")
  }
  ngOnInit() {
  }

}
