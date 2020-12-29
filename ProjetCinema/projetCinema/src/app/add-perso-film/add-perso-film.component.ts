import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';

@Component({
  selector: 'app-add-perso-film',
  templateUrl: './add-perso-film.component.html',
  styleUrls: ['./add-perso-film.component.scss']
})
export class AddPersoFilmComponent implements OnInit {

  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router) { }
  filmInfo = {noFilm:1,titre:"bla"}
  defaultFilm= {noFilm:1,titre:'Léon'}
  titre
  films
  acteurs
  ngOnInit(): void {
    this.acteurs = this.acteurService.getActeurList()

  }
  onSubmit(form: NgForm) {
    this.personnageService.updatePerso(form.value)
    this.router.navigate(["/films/"+this.filmInfo.noFilm]);
  }
}