import { Acteur } from '../models/acteur.model';

import { Subject } from 'rxjs/';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class ActeurService {
  private acteurs: Acteur[];  



  getActeurById(id: number) {
    const promise = new Promise((resolve, reject) => { 
      this.httpClient.get<any[]>('http://localhost:8080/getActeur/'+id)
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
  


  getActeurList(){

    return [{noAct:1,nomAct:'gg'},{noAct:2,nomAct:'wp'}]
  }

  constructor(private httpClient: HttpClient) { }
  acteurSubject = new Subject<any[]>();
  acteurIdSubject = new Subject<any>();

  emitActeurSubject() {
    this.acteurSubject.next(this.acteurs.slice());
  }

  emitActeurIdSubject() {
    this.acteurIdSubject.next(this.acteurs.slice());
  }

  getActeurs() {
    this.httpClient
      .get<any[]>('http://localhost:8080/getActeurs')
      .subscribe(
        (response) => {
          this.acteurs = response;
          this.emitActeurSubject();
        },
        (error) => {
          console.log('Erreur ! : ' + error);
        }
      );
  }

}