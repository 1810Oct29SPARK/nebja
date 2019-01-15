import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  movieId: number;

  constructor() { }

  getMovieId() {
    return this.movieId;
  }

  setMovieId(id) {
    this.movieId = id;
  }
}
