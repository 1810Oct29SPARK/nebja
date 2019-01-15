import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  user: any;

  movieId: number;

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
}
