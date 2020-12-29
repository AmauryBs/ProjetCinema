import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';

@Component({
  selector: 'app-update-perso-film',
  templateUrl: './update-perso-film.component.html',
  styleUrls: ['./update-perso-film.component.scss']
})
export class UpdatePersoFilmComponent implements OnInit {
  perso={noFilm:0,noAct:0,nomPerso:"",titre:"",nomAct:"", prenAct:""}
  oldPerso
  titre

  acteurs
  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router,  private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.acteurs = this.acteurService.getActeurList()
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
    this.router.navigate(["/films/"+this.perso.noFilm]);
  }
}


