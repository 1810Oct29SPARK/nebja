import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { YoutubeService } from '../youtube.service';

@Component({
  selector: 'app-youtube-trailers',
  templateUrl: './youtube-trailers.component.html',
  styleUrls: ['./youtube-trailers.component.css']
})
export class YoutubeTrailersComponent implements OnInit {
  videoArray=[];
  constructor(private YoutubeService: YoutubeService) { }

  ngOnInit() {
    this.getVideo();
  }

  getVideo()
    {
      
      this.YoutubeService.getVideoList().then((data) => {
        //adding returned array to videoArray
         data.items.forEach(element => {
           this.videoArray.push(element);

           
         })
         this.videoArray.forEach(element=>{
           //creating p element with video title
          let title=document.createElement("p");
          let titleText = document.createTextNode(element.snippet.title);
          title.appendChild(titleText);

          //getting video thumbnail
          let thumbNail=document.createElement("img");
          thumbNail.src=(element.snippet.thumbnails.medium.url);

          //getting youtube URL and appending the a link to the thumbnail,
          //making it the clickable link to the youtube video
          let videoId = element.id.videoId;
          let videoUrl = 'https://www.youtube.com/watch?v='+videoId;
          let link=document.createElement("a");
          link.setAttribute("href", videoUrl);
          link.setAttribute("target","_blank");
          link.append(thumbNail);

          //adding all of the above elements to a div and then appending that div
          //to the youtube div
          let holder=document.createElement("div");
          holder.classList.add("video");
          holder.append(link,title);

          document.getElementById("youtube").append(holder);

         });
       },(err) => {
         console.error(err);
       });
    }

}
