import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Film } from '../models/film.model';
import { FilmService } from '../services/film.service';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.scss']
})
export class FilmListComponent implements OnInit, OnDestroy {

  films: Film[];
  filmSubscription: Subscription;

  constructor(private filmService: FilmService) { }

  ngOnInit() {
    this.filmSubscription = this.filmService.filmSubject.subscribe(
      (films: Film[]) => {
        this.films = films;
      }
    );
    this.filmService.emitFilm();
  }




  ngOnDestroy() {
    this.filmSubscription.unsubscribe();
  }


}
