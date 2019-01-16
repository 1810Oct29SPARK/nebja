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
      this.service.getAllUsers().subscribe((data) => {
        this.users = data;
        console.log(data)
        // how do I know which user's image I'm replacing?
      })
    console.log("replaceUserImg() triggered!")
  }

  banUser() {
    console.log("banUser() triggered!")
    let id;
    this.service.deleteUser(id)
    // how do I know which id I'm interacting with?
  }

  removeReview(){
    console.log("removeReview() triggered!")
    this.service.deleteReview()
  }

  approveReview(){
    console.log("approveReview() triggered!")
  }

  promoteToMod(role) {
    console.log("promoteToMod() triggered!")
    if (role == "User") {
      this.dataService.setUserRole("Moderator");
    }
  }

  removeMod(){
    console.log("removeMod() triggered!")
  }

  ngOnInit() {
  }

}
