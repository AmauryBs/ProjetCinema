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
import { Message } from '../models/message.model';

@Component({
  selector: 'app-add-perso',
  templateUrl: './add-perso.component.html',
  styleUrls: ['./add-perso.component.scss']
})
export class AddPersoComponent implements OnInit, OnDestroy {

  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router, private route: ActivatedRoute, protected alertService: AlertService) { }
  acteurInfo: Observable<Acteur>;
  films: Film[];
  filmSubscription: Subscription;
  ngOnInit(): void {
    this.filmSubscription = this.filmService.filmSubject.subscribe(
      (films: Film[]) => {
        this.films = films;
      }
    );
    this.filmService.getFilms()
    const noAct = this.route.snapshot.params['id'];
    this.acteurService.getActeurById(+noAct).then((res: Acteur)=>{
      this.acteurInfo = of(res)
    }
    )
  }

  delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
  }

  onSubmit(form: NgForm) {
    console.log(form.value.nomPerso)
    if(form.value.nomPerso==''){
      var options = {
        autoClose: true,
        keepAfterRouteChange: false
    };
      this.alertService.error('Veuillez entrer un nom de personnage',options) 
    }
    else{
      this.personnageService.addPerso(form.value).then(async (res:Message) =>{
        var options = {
          autoClose: true,
          keepAfterRouteChange: true
        };
        if(res.message=="Success"){
          this.alertService.success('personnage créé',options)
          await this.delay(500)
          this.router.navigate(["/acteurs/"+form.value.noAct]);
        }else if(res.message=="Already exists"){
          this.alertService.warn("Un personnage avec cet acteur et ce film existe déjà",options)
        }else{
          this.alertService.error("erreur, impossible d'ajouter ce personnage",options)
        }
      })
    }
  }

  ngOnDestroy(){
    this.filmSubscription.unsubscribe()
  }
}
