import { Acteur } from '../models/acteur.model';

import { Subject } from 'rxjs/';

export class ActeurService {
  private acteurs: Acteur[] = [
    new Acteur(1,"Reno","Jean", new Date("1948-07-30"),null),
    new Acteur(2,"Bourvil","André",new Date("1917-07-27"),new Date("1970-09-23")
    )
  ];  acteurSubject = new Subject<Acteur[]>();


  getActeurs(){
    return this.acteurs
  }
  getActeurById(id: number) {
    const acteur = this.acteurs.find(
      (s) => {
        return s.noAct === id;
      }
    );
    return acteur;
}


  getActeurList(){

    return [{noAct:1,nomAct:'gg'},{noAct:2,nomAct:'wp'}]
  }
}