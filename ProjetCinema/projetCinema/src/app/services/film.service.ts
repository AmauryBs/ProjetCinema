import { Film } from '../models/film.model';
import { Subject } from 'rxjs/';

export class FilmService {
  private films: Film[] = [
    new Film(1,"Léon",110, new Date("1994-04-14"), 17531000,69250000,{NoRea:3,NomRea:"Besson",PrenRea:"Luc"},{CodeCat:"PO",LibelleCat:"Policier",image:"https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Police-IMG_4105.jpg/300px-Police-IMG_4105.jpg"}),
    new Film(2,"Léon2",110, new Date("1994-04-14"), 17531000,69250000,{NoRea:3,NomRea:"Besson",PrenRea:"Luc"},{CodeCat:"PO",LibelleCat:"Policier",image:"https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Police-IMG_4105.jpg/300px-Police-IMG_4105.jpg"}
    )];  
    filmSubject = new Subject<Film[]>();


  emitFilm() {
    this.filmSubject.next(this.films.slice());
  }

  addFilm(film: Film) {
    this.films.push(film);
    this.emitFilm();
  }
  
  getFilmById(id: number) {
    const film = this.films.find(
      (s) => {
        return s.noFilm === id;
      }
    );
    return film;
}
  getFilmList(){

    return [{noFilm:1,titre:'Léon'},{noFilm:2,titre:'Léa'}]
  }

}