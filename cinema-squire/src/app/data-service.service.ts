import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  user: any;

  movieId: number;
  userId: number;
  userImg: any;

  constructor() { }

  setUser(u) {
    this.user = u;
  }

  getUser() {
    return this.user;
  }

  getMovieId() {
    return this.movieId;
  }

  setMovieId(id) {
    this.movieId = id;
  }

  getUserId() {
    return this.userId;
  }

  setUserId(id) {
    this.userId = id;
  }

  getUserImg() {
    return this.userImg;
  }

  setUserImg(img) {
    this.userImg = img;
  }
}
