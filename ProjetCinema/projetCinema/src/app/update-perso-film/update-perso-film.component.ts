import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, Subscription,of } from 'rxjs';
import { Acteur } from '../models/acteur.model';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';
import { AlertService } from '../_alert';

@Component({
  selector: 'app-update-perso-film',
  templateUrl: './update-perso-film.component.html',
  styleUrls: ['./update-perso-film.component.scss']
})
export class UpdatePersoFilmComponent implements OnInit {
  perso: Observable<any>;
  acteurs:Acteur[]
  acteurSubscription: Subscription;
  noFilm;noAct;nomPerso;

  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router,  private route: ActivatedRoute,protected alertService: AlertService) { }

  ngOnInit(): void {
    this.acteurSubscription = this.acteurService.acteurSubject.subscribe(
      (acteurs: Acteur[]) => {
        this.acteurs = acteurs;
      }
    );
    this.acteurService.getActeurs()

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
  onSubmit(form: NgForm) {
    if(form.value.nomPerso==''){
      var options = {
        autoClose: true,
        keepAfterRouteChange: false
    };
      this.alertService.error('Veuillez entrer un nom de personnage',options) 
    }
    else{
      this.personnageService.updatePerso(form.value).then(res =>{console.log(res)
        var options = {
          autoClose: true,
          keepAfterRouteChange: true
        };
        if(res=="Success"){
          this.alertService.success('personnage mis à jour',options)
          this.router.navigate(["/films/"+form.value.noFilm]);
        }else if(res=="Inserted"){
          this.alertService.success("personnage non trouvé, ajout d'un nouveau personnage",options)
          this.router.navigate(["/films/"+form.value.noFilm]);
        }else{
          this.alertService.success("erreur, impossible de modifier ce personnage",options)
        }
        this.alertService.success('personnage mis à jour',options)
      })
    }
  }
}


