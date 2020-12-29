import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-modif-perso',
  templateUrl: './modif-perso.component.html',
  styleUrls: ['./modif-perso.component.scss']
})
export class ModifPersoComponent implements OnInit {
  perso = {titre:"Léon",nomPerso:"Jax",nomAct:"gg", noAct:2, noFilm:1}
  oldPerso = {titre:"Léon",nomPerso:"Jax",nomAct:"gg", noAct:2, noFilm:1}
  defaultFilm= {noFilm:1,titre:'Léon'}
  titre
  films
  acteurs
  constructor(private acteurService:ActeurService, private filmService: FilmService, private router: Router) { }

  ngOnInit(): void {
    this.titre="Modification d'un personnage"
    this.films =this.filmService.getFilmList()
    this.acteurs = this.acteurService.getActeurList()

  }
  onSubmit(form: NgForm) {
    this.acteurService.updatePerso(form.value)
    this.router.navigate(["/acteurs/"+this.perso.noAct]);
  }
}
