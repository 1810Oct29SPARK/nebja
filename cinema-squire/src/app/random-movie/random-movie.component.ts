import { Component, OnInit, Input } from '@angular/core';
import { ApiClientService } from '../api-client.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-random-movie',
  templateUrl: './random-movie.component.html',
  styleUrls: ['./random-movie.component.css']
})
export class RandomMovieComponent implements OnInit {

  stuff: any;
  randomMovie: any;

  trueGenres = "&with_genres=";
  trueRatings= "&certification_country='US'&certification=";
  onSubmit(form: NgForm) {
    console.log(form);
    if (form.value.actionBox == true) {
      this.trueGenres += "28,";
    } 
    if (form.value.adventureBox == true) {
      this.trueGenres += "12,";
    } 
    if (form.value.animationBox == true) {
      this.trueGenres += "16,";
    } 
    if (form.value.comedyBox == true) {
      this.trueGenres += "35,";
    } 
    if (form.value.crimeBox == true) {
      this.trueGenres += "80,";
    } 
    if (form.value.docBox == true) {
      this.trueGenres += "99,";
    } 
    if (form.value.dramaBox == true) {
      this.trueGenres += "18,";
    } 
    if (form.value.familyBox == true) {
      this.trueGenres += "10751,";
    } 
    if (form.value.fantasyBox == true) {
      this.trueGenres += "14,";
    } 
    if (form.value.historyBox == true) {
      this.trueGenres += "36,";
    } 
    if (form.value.horrorBox == true) {
      this.trueGenres += "27,";
    } 
    if (form.value.musicBox == true) {
      this.trueGenres += "10402,";
    } 
    if (form.value.mysteryBox == true) {
      this.trueGenres += "9648,";
    } 
    if (form.value.romanceBox == true) {
      this.trueGenres += "10749,";
    } 
    if (form.value.sciFiBox == true) {
      this.trueGenres += "878,";
    } 
    if (form.value.tvMovieBox == true) {
      this.trueGenres += "10770,";
    } 
    if (form.value.thrillerBox == true) {
      this.trueGenres += "53,";
    } 
    if (form.value.warBox == true) {
      this.trueGenres += "10752,";
    } 
    if (form.value.westernBox == true) {
      this.trueGenres += "37,";
    } 

    if (form.value.ratedG == true) {
      this.trueRatings += "G,";
    }
    if (form.value.ratedPG == true) {
      this.trueRatings += "PG,";
    }
    if (form.value.ratedPG13 == true) {
      this.trueRatings += "PG-13,";
    }
    if (form.value.ratedR == true) {
      this.trueRatings += "R,";
    }
    if (form.value.ratedNC17 == true) {
      this.trueRatings += "NC-17,";
    }
    if (form.value.ratedNR == true) {
      this.trueRatings += "NR,";
    }
    this.service.getRandomMovie(this.trueGenres, this.trueRatings).subscribe((data) => {
      
      this.stuff = data;
      let randomIndex: number;
      randomIndex = Math.floor(Math.random() * 20);
      console.log(data);
      this.randomMovie = this.stuff.results[randomIndex];
      console.log(this.randomMovie)
    })
  }

  

  
// To display a random movie
      // create image, title, year, synopsis variables and set them equal to:
      // image = movies[randomIndex].[img]
      // title = movies[randomIndex].[title]
      // year = movies[randomIndex].[year]
      // synopsis = movies[randomIndex].[synopsis]
  
  prompt = "Use the form below to search for a new movie."
  // To get a random number between 0 and the end of my results, I have to use:
  // 
  

  // Math.floor rounds a number to the nearest integer (rounds down)
  // Math.random generates a number between 0 and 1 (but it can never EQUAL 1)
  // This makes it so that Math.floor(Math.random * array.length) can never give us a number bigger than array.length - 1 
   

  constructor(private service: ApiClientService) { 
    // this.service.getRandomMovie().subscribe((data) => {
    //   this.movies = data;
    //   console.log(this.movies);
    // })
  }

  
  ngOnInit() {
  }

  

}
