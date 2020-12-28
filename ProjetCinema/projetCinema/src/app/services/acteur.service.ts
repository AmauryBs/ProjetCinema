import { Acteur } from '../models/acteur.model';

import { Subject } from 'rxjs/';

export class ActeurService {
  private acteurs: Acteur[] = [
    new Acteur(1,"Reno","Jean", new Date("1948-07-30"),null),
    new Acteur(4,"Bourvil","André",new Date("1917-07-27"),new Date("1970-09-23")
    )
];  acteurSubject = new Subject<Acteur[]>();
private persos =[{noFilm:1,noAct:2,titre:'Léon',nomPerso:'Jax'}, {noFilm:2,noAct:3,titre:'léa',nomPerso:'Ja'}]


  emitActeur() {
    this.acteurSubject.next(this.acteurs.slice());
  }

  addActeur(acteur: Acteur) {
    this.acteurs.push(acteur);
    this.emitActeur();
  }
  
  getActeurById(id: number) {
    const acteur = this.acteurs.find(
      (s) => {
        return s.noAct === id;
      }
    );
    return acteur;
}


  getPersoByActeur(id: number) {

    return this.persos
  }

  removePerso(perso){
    for (var i = 0; i < this.persos.length; i++){
      // look for the entry with a matching  value
      if (this.persos[i] == perso ){
        this.persos.splice(i, 1);
        console.log(this.persos[i])
        break;
      }
    }
    return this.persos
  }

  updatePerso(newPerso){
    console.log(newPerso)
    for (var i = 0; i < this.persos.length; i++){
      // look for the entry with a matching  value
      if (this.persos[i] == newPerso.oldPerso ){
        this.persos[i].noFilm = newPerso.film.noFilm
        this.persos[i].titre = newPerso.film.titre
        this.persos[i].nomPerso = newPerso.nomPerso
        break;
      }
      
    }
    console.log(this.persos)
  }

  getActeurList(){

    return [{noAct:1,nom:'gg'},{noAct:2,nom:'wp'}]
  }
}