import { Film } from '../models/film.model';
import { Subject } from 'rxjs/';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class FilmService {
  private films: Film[];

  filmSearch(value, option) {
    const promise = new Promise((resolve, reject) => {
      let url = 'http://localhost:8080/getFilms/';
      let body = new HttpParams();
      switch (option) {
        case 'titre': {
          url = url + 'titre';
          body = body.set('titre', value);
          break;
        }
        case 'real': {
          url = url + 'realisateur';
          body = body.set('nomOrPrenRea', value);
          break;
        }
        case 'act': {
          url = url + 'acteur';
          body = body.set('nomOrPrenAct', value);
          break;
        }
        case 'genre': {
          url = url + 'cat';
          body = body.set('libelleCat', value);
          break;
        }
        default: {
          url;
          break;
        }
      }
      this.httpClient.post<any[]>(url,body).toPromise()
      .then(
        (res: any) => {
          const data = res;
          resolve(data);
        },
        (err) => {
          reject(err);
        }
      );
    });
    return promise
  }

  constructor(private httpClient: HttpClient) {}
  filmSubject = new Subject<any[]>();
  filmSearchSubject = new Subject<any[]>();

  emitFilmSubject() {
    this.filmSubject.next(this.films.slice());
  }


  getFilms() {
    this.httpClient.get<any[]>('http://localhost:8080/getFilms').subscribe(
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
      this.httpClient
        .get<any[]>('http://localhost:8080/getFilm/' + id)
        .toPromise()
        .then(
          (res: any) => {
            const data = res;
            resolve(data);
          },
          (err) => {
            reject(err);
          }
        );
    });
    return promise;
  }
}
