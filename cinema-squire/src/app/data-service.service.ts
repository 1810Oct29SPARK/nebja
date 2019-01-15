import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  movieId: number;
  userId: number;
  userImg: any;

  constructor() { }

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
