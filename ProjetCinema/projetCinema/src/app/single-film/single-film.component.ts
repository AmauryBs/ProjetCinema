import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Film } from '../models/film.model';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';

@Component({
  selector: 'app-single-film',
  templateUrl: './single-film.component.html',
  styleUrls: ['./single-film.component.scss']
})
export class SingleFilmComponent implements OnInit {

  film
  displayedColumns: string[] = ['titre', 'perso', 'action'];
  acteur
  persos
  constructor(private filmService: FilmService, private personnageService: PersonnageService,
    private route: ActivatedRoute, private acteurService: ActeurService) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.film = this.filmService.getFilmById(+id).then( res =>{
      console.log(res)
      return new Film(res[0][0],res[0][1],res[0][3],res[0][5],res[0][2], res[0][4],res[0][7],res[0][6]) })
    this.persos = this.personnageService.getPersoByFilm(id)
    for(var perso of this.persos){
      const res = this.acteurService.getActeurById(perso.noAct).then(res=>{return res[0][1] + " " + res[0][2];})
      perso["nomAct"] = res
    }
  }

  remove(perso){
    this.personnageService.removePerso(perso)
  }
}
