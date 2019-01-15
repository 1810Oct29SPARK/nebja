import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { ProfileInformationComponent} from './profile-information/profile-information.component';

const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'reviews', component: ReviewsComponent },
    { path: 'profile', component: ProfileInformationComponent}
  ];

export const routingModule: ModuleWithProviders = RouterModule.forRoot(routes);