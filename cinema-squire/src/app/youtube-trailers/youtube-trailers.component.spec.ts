import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YoutubeTrailersComponent } from './youtube-trailers.component';

describe('YoutubeTrailersComponent', () => {
  let component: YoutubeTrailersComponent;
  let fixture: ComponentFixture<YoutubeTrailersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YoutubeTrailersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YoutubeTrailersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
