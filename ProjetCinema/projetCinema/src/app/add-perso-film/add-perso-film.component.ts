import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';

@Component({
  selector: 'app-add-perso-film',
  templateUrl: './add-perso-film.component.html',
  styleUrls: ['./add-perso-film.component.scss']
})
export class AddPersoFilmComponent implements OnInit {

  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router, private route: ActivatedRoute) { }
  filmInfo 
  acteurs
  ngOnInit(): void {
    this.acteurs = this.acteurService.getActeurList()
    const noFilm = this.route.snapshot.params['id'];
    this.filmInfo = this.filmService.getFilmById(+noFilm)

  }
  onSubmit(form: NgForm) {
    this.personnageService.addPerso(form.value)
    this.router.navigate(["/films/"+this.filmInfo.noFilm]);
  }
}