import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Film } from '../models/film.model';
import { FilmService } from '../services/film.service';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-search-film',
  templateUrl: './search-film.component.html',
  styleUrls: ['./search-film.component.scss']
})
export class SearchFilmComponent implements OnInit {

  films: Observable<Film[]>;
  option
  value
  constructor(private filmService: FilmService, private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    this.value = this.route.snapshot.params['value'];
    this.option = this.route.snapshot.params['option'];
    this.filmService.filmSearch(this.value,this.option).then((res: Film[])=>{
      this.films = of(res)
    })

  }


}
