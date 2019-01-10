import { Component, OnInit } from '@angular/core';
import { ApiClientService } from '../api-client.service';

@Component({
  selector: 'app-news-carousel',
  templateUrl: './news-carousel.component.html',
  styleUrls: ['./news-carousel.component.css']
})
export class NewsCarouselComponent implements OnInit {

  constructor(private service: ApiClientService) { }

  news: any;

  ngOnInit() {
    this.service.getNews().subscribe((data) =>{
      this.news = data;
      console.log(this.news);
    })
  }

}
