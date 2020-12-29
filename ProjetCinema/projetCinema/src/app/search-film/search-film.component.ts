import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Film } from '../models/film.model';
import { FilmService } from '../services/film.service';

@Component({
  selector: 'app-search-film',
  templateUrl: './search-film.component.html',
  styleUrls: ['./search-film.component.scss']
})
export class SearchFilmComponent implements OnInit, OnDestroy {

  films

  constructor(private filmService: FilmService, private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    const value = this.route.snapshot.params['value'];
    const option = this.route.snapshot.params['option'];

    this.films = this.filmService.filmSearch(value,option)
    console.log(this.films)

  }

  ngOnDestroy() {
  }

  onSubmit(form: NgForm) {
    this.router.navigate(["/films/search",form.value.value,form.value.option]);

}


}
