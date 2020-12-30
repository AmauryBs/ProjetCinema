import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Film } from '../models/film.model';
import { FilmService } from '../services/film.service';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.scss']
})
export class FilmListComponent implements OnInit {

  films: Film[];
  filmSubscription: Subscription;

  constructor(private filmService: FilmService, private router: Router) { }

  ngOnInit() {
    this.filmSubscription = this.filmService.filmSubject.subscribe(
      (films: Film[]) => {
        this.films = films;
      }
    );
    this.filmService.getFilms()

  }



  onSubmit(form: NgForm) {
    this.router.navigate(["/films/search",form.value.value,form.value.option]);
}

  ngOnDestroy(){
    this.filmSubscription.unsubscribe()
  }
}
