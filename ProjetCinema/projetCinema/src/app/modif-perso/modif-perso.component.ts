import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import {ActivatedRoute, Router} from '@angular/router';
import { PersonnageService } from '../services/personnage.service';

@Component({
  selector: 'app-modif-perso',
  templateUrl: './modif-perso.component.html',
  styleUrls: ['./modif-perso.component.scss']
})
export class ModifPersoComponent implements OnInit {
  perso={noFilm:0,noAct:0,nomPerso:"",titre:"",nomAct:"", prenAct:""}
  oldPerso
  titre
  films
  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.films =this.filmService.getFilmList()
    const noFilm = +this.route.snapshot.params['noFilm'];
    const noAct = +this.route.snapshot.params['noAct'];
    const nomPerso = this.route.snapshot.params['nomPerso'];
    this.perso["noFilm"] = noFilm
    this.perso["noAct"] = noAct
    this.perso["nomPerso"] = nomPerso
    this.perso["titre"] = this.filmService.getFilmById(+noFilm).titre
    this.perso["nomAct"] = this.acteurService.getActeurById(+noAct).nomAct
    this.perso["prenAct"] = this.acteurService.getActeurById(+noAct).prenAct
    this.oldPerso =this.perso
  }
  onSubmit(form: NgForm) {
    this.personnageService.updatePerso(form.value)
    this.router.navigate(["/acteurs/"+this.perso.noAct]);
  }
}
