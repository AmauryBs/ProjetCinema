import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';
import { Observable, of, Subscription } from 'rxjs';
import { Film } from '../models/film.model';
import { Acteur } from '../models/acteur.model';
import { AlertService } from '../_alert';

@Component({
  selector: 'app-add-perso-film',
  templateUrl: './add-perso-film.component.html',
  styleUrls: ['./add-perso-film.component.scss']
})
export class AddPersoFilmComponent implements OnInit, OnDestroy {

  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router, private route: ActivatedRoute, protected alertService: AlertService) { }
  filmInfo: Observable<Film>;
  acteurs:Acteur[]
  acteurSubscription: Subscription;
  ngOnInit(): void {
    this.acteurSubscription = this.acteurService.acteurSubject.subscribe(
      (acteurs: Acteur[]) => {
        this.acteurs = acteurs;
      }
    );
    this.acteurService.getActeurs()
    const noFilm = this.route.snapshot.params['id'];
    this.filmService.getFilmById(+noFilm).then((res: Film)=>{
      this.filmInfo = of(res)
    }
    )
  }
  onSubmit(form: NgForm) {
    if(form.value.nomPerso==''){
      var options = {
        autoClose: true,
        keepAfterRouteChange: false
    };
      this.alertService.error('Veuillez entrer un nom de personnage', options) 
    }
    else{
      this.personnageService.addPerso(form.value).then(res =>{console.log(res)
        var options = {
          autoClose: true,
          keepAfterRouteChange: true
        };
        if(res=="Success"){
          this.alertService.success('personnage créé',options)
          this.router.navigate(["/films/"+form.value.noFilm])
        }else if(res=="Cannot Insert"){
          this.alertService.success("Un personnage avec cette Acteur et ce film existe déjà",options)
          this.router.navigate(["/films/"+form.value.noFilm])
        }else{
          this.alertService.success("erreur, impossible d'ajouter ce personnage",options)
        }
      })
    }
  }

  
  ngOnDestroy(){
    this.acteurSubscription.unsubscribe()
  }
}