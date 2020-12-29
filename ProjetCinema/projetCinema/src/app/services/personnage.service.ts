import { Personnage } from "../models/personnage.model"

export class PersonnageService {

  private persos =[new Personnage(1,1,'Jax'), new Personnage(2,2,'Ja')]
  
  getPersoByFilm(id:number){
      return this.persos
  }

  getPersoByActeur(id: number) {

      return this.persos
  }

  removePerso(perso){
      for (var i = 0; i < this.persos.length; i++){
        // look for the entry with a matching  value
        if (this.persos[i] == perso ){
          this.persos.splice(i, 1);
          break;
        }
      }
      return this.persos
    }
  
  updatePerso(newPerso){
    for (var i = 0; i < this.persos.length; i++){
      // look for the entry with a matching  value
      if (this.persos[i] == newPerso.oldPerso ){
        this.persos[i].noFilm = newPerso.film.noFilm
        this.persos[i].nomPerso = newPerso.nomPerso
        break;
      } 
    }
  }

  addPerso(newPerso){}
}