import { Personnage } from "../models/personnage.model"
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { throwError } from "rxjs";
import { catchError } from "rxjs/operators";

@Injectable()
export class PersonnageService {

  private persos =[];

  constructor(private httpClient: HttpClient) { }
  
  getPersoByFilm(id:number){
      const promise = new Promise((resolve, reject) => { 
        this.httpClient.get<any[]>('http://localhost:8080/getPersonnages/film/'+id)
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


  getPersoByids(noFilm, noAct){
    let body = new HttpParams();
    body = body.set('noFilm', noFilm);
    body = body.set('noAct',  noAct);
    const promise = new Promise((resolve, reject) => { 
      this.httpClient.post<any[]>('http://localhost:8080/getPersonnageFromIds',body)
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


  getPersoByActeur(id: number) {
      const promise = new Promise((resolve, reject) => { 
        this.httpClient.get<any[]>('http://localhost:8080/getPersonnages/acteur/'+id)
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

  removePerso(perso){
    let body = new HttpParams();
    body = body.set('noFilm', perso.noFilm.noFilm);
    body = body.set('noAct',  perso.noAct.noAct);
    return this.httpClient
      .post('http://localhost:8080/supprPersonnage', body)
      .pipe(
        );
  }
  
  updatePerso(persolist){
    let body = new HttpParams();
    body = body.set('noFilmOld', persolist.oldPerso.noFilm);
    body = body.set('noActOld', persolist.oldPerso.noAct);
    body = body.set('noFilm', persolist.noFilm);
    body = body.set('noAct',  persolist.noAct);
    body = body.set('nomPers', persolist.nomPerso);
    return this.httpClient
      .put('http://localhost:8080/modifPersonnage', body)
      .pipe(
      );
  }

  addPerso(newPerso){
    let body = new HttpParams();
    body = body.set('noFilm', newPerso.noFilm);
    body = body.set('noAct',  newPerso.noAct);
    body = body.set('nomPers', newPerso.nomPerso);
    return this.httpClient
      .post('http://localhost:8080/ajoutPersonnage', body)
      .pipe(
      );

  }
}