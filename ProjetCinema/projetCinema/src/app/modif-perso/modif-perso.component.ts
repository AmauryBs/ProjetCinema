import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import {ActivatedRoute, Router} from '@angular/router';
import { PersonnageService } from '../services/personnage.service';
import { Observable,of, Subscription } from 'rxjs';
import { Film } from '../models/film.model';
import { AlertService } from '../_alert';

@Component({
  selector: 'app-modif-perso',
  templateUrl: './modif-perso.component.html',
  styleUrls: ['./modif-perso.component.scss']
})
export class ModifPersoComponent implements OnInit, OnDestroy {
  perso: Observable<any>;
  filmSubscription: Subscription;
  noFilm;noAct;nomPerso;
  films
  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router, private route: ActivatedRoute,protected alertService: AlertService) { }

  ngOnInit(): void {
    this.filmSubscription = this.filmService.filmSubject.subscribe(
      (films: Film[]) => {
        this.films = films;
      }
    );
    this.filmService.getFilms()

    this.noFilm = +this.route.snapshot.params['noFilm'];
    this.noAct = +this.route.snapshot.params['noAct'];
    this.nomPerso = this.route.snapshot.params['nomPerso'];

    this.perso["titre"] = this.personnageService.getPersoByids(+this.noFilm,this.noAct ).then(
      (value:any)=>{
        const tempperso={}
        tempperso["noFilm"] = this.noFilm
        tempperso["noAct"] = this.noAct
        tempperso["nomPerso"] = this.nomPerso
        tempperso["titre"] = value.noFilm.titre
        tempperso["nomAct"] = value.noAct.nomAct
        tempperso["prenAct"] = value.noAct.prenAct
        this.perso = of(tempperso)
      }
    )
  }

  ngOnDestroy(){
    this.filmSubscription.unsubscribe()
  }

  onSubmit(form: NgForm) {
    this.personnageService.updatePerso(form.value).then(res =>{console.log(res)
      this.alertService.success('personnage mis à jour')
      this.router.navigate(["/acteurs/"+form.value.noAct]);
    })

  }
}
