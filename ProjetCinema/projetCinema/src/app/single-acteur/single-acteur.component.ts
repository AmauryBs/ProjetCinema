import { Component, OnInit, ViewChild  } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Acteur } from '../models/acteur.model';
import { ActeurService } from '../services/acteur.service';
import {Router} from '@angular/router';
import { PersonnageService } from '../services/personnage.service';
import { FilmService } from '../services/film.service';


@Component({
  selector: 'app-single-acteur',
  templateUrl: './single-acteur.component.html',
  styleUrls: ['./single-acteur.component.scss']
})


export class SingleActeurComponent implements OnInit {

  acteur: Acteur;
  persos

  constructor(private acteurService: ActeurService, private filmService: FilmService, private personnageService: PersonnageService, private route: ActivatedRoute, private routeur : Router) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.acteur = this.acteurService.getActeurById(+id);
    this.persos = this.personnageService.getPersoByActeur(+id)
    for(var perso of this.persos){
      perso["titre"] =this.filmService.getFilmById( perso.noFilm).titre
    }
  }

  remove(perso){
    this.personnageService.removePerso(perso)
  }

 

  update(perso){
    this.routeur.navigate(['/updatePerso', { noFilm: perso.noFilm, noAct: perso.noAct,nomPerso: perso.nomPerso} ]);
  }

}
