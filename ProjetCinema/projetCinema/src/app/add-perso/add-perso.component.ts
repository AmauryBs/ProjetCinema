import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';

@Component({
  selector: 'app-add-perso',
  templateUrl: './add-perso.component.html',
  styleUrls: ['./add-perso.component.scss']
})
export class AddPersoComponent implements OnInit {

  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router) { }
  acteurInfo = {noAct:1,nomAct:"bla"}
  defaultFilm= {noFilm:1,titre:'Léon'}
  titre
  films
  acteurs
  ngOnInit(): void {
    this.films =this.filmService.getFilmList()
    this.acteurs = this.acteurService.getActeurList()

  }
  onSubmit(form: NgForm) {
    this.personnageService.updatePerso(form.value)
    this.router.navigate(["/acteurs/"+this.acteurInfo.noAct]);
  }
}
