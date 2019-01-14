import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiClientService {

  constructor(private http: HttpClient) { }

  getNews(): Observable<any> {
    return this.http.get('https://newsapi.org/v2/top-headlines?country=us&category=entertainment&pageSize=15&apiKey=fd9ec8dbca4c475395e2bcdde1262369');
  }

  searchMovie(movie): Observable<any> {
    return this.http.get('https://api.themoviedb.org/3/search/movie?api_key=1e690b95d21161ee9cf641b3a944487a&query=' + movie);
  }

  getUpcomingMovies(): Observable<any> {
    return this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=1e690b95d21161ee9cf641b3a944487a&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&primary_release_date.gte=2019-01-11');
  }

  getRandomMovie(trueGenres, trueRatings): Observable<any> {
    return this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=f338392353fe947d6278ee2e05e3745c&language=en-US&sort_by=popularity.desc' + trueRatings + '&include_adult=false&include_video=false' + trueGenres);
  }

  // getRandomMovie(): Observable<any> {
  //   // make a queryString variable and set it equal to an empty string. 
  //   let queryString: String = "";
  //       // get titleInput from random-movie-component

  //   // document.getElementById() (isChecked function)



  //   let actorInput = "";
  //   let genres: Boolean[] = [];
  //   // get actorInput from random-movie-component
  //     // if actorInput != null, add it to the query string
  //     if (actorInput != "") {
  //       queryString += actorInput;
  //     }
  //   // get genres from random-movie-component
  //     // for every element in genres, if genre.checked is true, add it to the query string. 
  
  //   return this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=f338392353fe947d6278ee2e05e3745c&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false');
  // }

}
