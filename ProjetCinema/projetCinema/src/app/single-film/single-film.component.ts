import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Acteur } from '../models/acteur.model';
import { Film } from '../models/film.model';
import { Personnage } from '../models/personnage.model';
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
    this.film = this.filmService.getFilmById(+id).then( (res:Film) =>{
      res.dateSortie = new Date(res.dateSortie)
      return res})
    this.persos = this.personnageService.getPersoByFilm(+id).then( (res:Personnage) =>{
      return res})
    for(var perso of this.persos){
      const res = this.acteurService.getActeurById(perso.noAct).then((res:Acteur)=>{return res.prenAct + " " + res.nomAct;})
      perso["nomAct"] = res
    }
  }

  remove(perso){
    this.personnageService.removePerso(perso)
  }
}
