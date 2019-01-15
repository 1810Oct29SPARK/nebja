import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material';
import { HttpClientModule } from '@angular/common/http';
import {MatStepperModule} from '@angular/material/stepper';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { BarRatingModule } from 'ngx-bar-rating';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchFormComponent } from './search-form/search-form.component';
import { NewsCarouselComponent } from './news-carousel/news-carousel.component';
import { ApiClientService} from './api-client.service';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { UpcomingMoviesComponent } from './upcoming-movies/upcoming-movies.component';
import { ReviewsComponent } from './reviews/reviews.component'
import { DataServiceService } from './data-service.service';
import { Routes, RouterModule } from '@angular/router';
import { ProfileInformationComponent } from './profile-information/profile-information.component';
import { YoutubeTrailersComponent } from './youtube-trailers/youtube-trailers.component';
import { HomeComponent } from './home/home.component'


const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'reviews', component: ReviewsComponent },
  { path: 'profile', component: ProfileInformationComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SearchFormComponent,
    NewsCarouselComponent,
    RegistrationFormComponent,
    UpcomingMoviesComponent,
    ReviewsComponent,
    ProfileInformationComponent,
    YoutubeTrailersComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    MatStepperModule,
    FormsModule,
    ReactiveFormsModule,
    MDBBootstrapModule.forRoot(),
    BarRatingModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ApiClientService, DataServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
