import { Component, OnInit, Input } from '@angular/core';
import { ApiClientService } from '../api-client.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-random-movie',
  templateUrl: './random-movie.component.html',
  styleUrls: ['./random-movie.component.css']
})
export class RandomMovieComponent implements OnInit {

  randomFormData: {name: String, content: String};
  randomIndex: number;
  prompt = "Use the form below to search for a new movie."
  // To get a random number between 0 and the end of my results, I have to use:
  // Math.floor(Math.random * array.length)
  

  // Math.floor rounds a number to the nearest integer (rounds down)
  // Math.random generates a number between 0 and 1 (but it can never EQUAL 1)
  // This makes it so that Math.floor(Math.random * array.length) can never give us a number bigger than array.length - 1 

  movies: any;
  titleInput: String = "";
  actorInput: String = "";
  genres: Boolean[] = []; 
  // [Action.checked, Adventure.checked, Animation.checked, Comedy.checked, Crime.checked, 
  // Documentary.checked, Drama.checked, Family.checked, Fantasy.checked, History.checked, 
  // Horror.checked, Music.checked, Mystery.checked, Romance.checked, ScienceFiction.checked, 
  // TVMovie.checked, Thriller.checked, War.checked, Western.checked]

  constructor(private service: ApiClientService) { 
    // this.service.getRandomMovie().subscribe((data) => {
    //   this.movies = data;
    //   console.log(this.movies);
    // })
  }

  // To display a random movie
      // create image, title, year, synopsis variables and set them equal to:
      // image = movies[randomIndex].[img]
      // title = movies[randomIndex].[title]
      // year = movies[randomIndex].[year]
      // synopsis = movies[randomIndex].[synopsis]
  ngOnInit() {
  }

  

}
