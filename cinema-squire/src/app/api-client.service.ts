import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiClientService {

  constructor(private http: HttpClient) { }


  login(f, e): Observable<any> {
    return this.http.post('http://localhost:8082/Nebja/login/sent', {
      "username": f,
      "password": e
    });
  }

  addMovie(id, title) {
    this.http.post('http://localhost:8080/Nebja/', {

    });
  }

  getReviewsByMovieId(id): Observable<any> {
    return this.http.get('http://localhost:8080/Nebja/'); 
  }

  submitReview(score, review, userId): Observable<any>{
    return this.http.post('http://localhost:8082/Nebja/user/review', {
      "score": score,
      "review": review,
      "userId": userId
    });
  }

  createAccount(user, pass, profileInfo): Observable<any> {
    return this.http.post('http://localhost:8080/Nebja/home/newuser', {
      "Username": user,
      "Password": pass,
      "Profile": profileInfo
    });
  }

  getAllUsers() {
    return this.http.get('http://localhost:8080/Nebja/home/')
  }
  
  uploadPhoto(photo) {
    return this.http.post('', {
      "picture": photo
    });
  }

  getNews(): Observable<any> {
    return this.http.get('https://newsapi.org/v2/top-headlines?country=us&category=entertainment&pageSize=15&apiKey=fd9ec8dbca4c475395e2bcdde1262369');
  }

  searchMovie(movie): Observable<any> {
    return this.http.get('https://api.themoviedb.org/3/search/movie?api_key=1e690b95d21161ee9cf641b3a944487a&query=' + movie);
  }

  searchMovieById(id): Observable<any> {
    return this.http.get('https://api.themoviedb.org/3/movie/' + id + '?api_key=1e690b95d21161ee9cf641b3a944487a')
  }

  getUpcomingMovies(): Observable<any> {
    return this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=1e690b95d21161ee9cf641b3a944487a&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&primary_release_date.gte=2019-01-11')
  }

  deleteUser(id) {
    return this.http.delete('http://localhost:8080/Nebja/home/')
  }

  deleteReview(): Observable <any> {
    return this.http.delete('http://localhost:8080/Nebja/home/')
  }

  changeUserRole() {
    // return this.http.put('http://localhost:8080/Nebja/home/', )
  }


}
