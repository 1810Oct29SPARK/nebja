import { Injectable } from '@angular/core';
import {YoutubeDataAPI} from 'youtube-v3-api';

@Injectable({
  providedIn: 'root'
})
export class YoutubeService {

  constructor() { }
  
    //making a call to the youtube API
    getVideoList(): Promise<any>{
  let apiKey='AIzaSyBqnkzjMQmk7OP1yqQ052JcoRBcP1onKMQ'; 
  let api = new YoutubeDataAPI(apiKey);
  let restrictions = {part:'snippet', type:'video', channelId: 'UCi8e0iOVk1fEOogdfu4YgfA'};
   return api.searchAll('movie trailer',5,restrictions);
  
  }
}
