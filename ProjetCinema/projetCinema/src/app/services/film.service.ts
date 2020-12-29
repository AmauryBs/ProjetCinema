import { Film } from '../models/film.model';
import { Subject } from 'rxjs/';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class FilmService {
  private films: Film[];


  getFilmList(){

    return [{noFilm:1,titre:'Léon'},{noFilm:2,titre:'Léa'}]
  }

  filmSearch(value,option){
    return this.films
  }

  constructor(private httpClient: HttpClient) { }
  filmSubject = new Subject<any[]>();

  emitFilmSubject() {
    this.filmSubject.next(this.films.slice());
  }

  getFilms() {
    this.httpClient
      .get<any[]>('http://localhost:8080/getFilms')
      .subscribe(
        (response) => {
          this.films = response;
          this.emitFilmSubject();
        },
        (error) => {
          console.log('Erreur ! : ' + error);
        }
      );
  }

  getFilmById(id: number) {
    const promise = new Promise((resolve, reject) => { 
      this.httpClient.get<any[]>('http://localhost:8080/getFilm/'+id)
    .toPromise()
    .then((res: any) => {
      const data = res
      resolve(data);
    },
    err => {
        reject(err)
      }
    );
  });
  return promise
}
}