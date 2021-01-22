import { Component, OnInit, ViewChild  } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Acteur } from '../models/acteur.model';
import { ActeurService } from '../services/acteur.service';
import {Router} from '@angular/router';
import { PersonnageService } from '../services/personnage.service';
import { FilmService } from '../services/film.service';
import { Observable, of } from "rxjs";
import { AlertService } from '../_alert';


@Component({
  selector: 'app-single-acteur',
  templateUrl: './single-acteur.component.html',
  styleUrls: ['./single-acteur.component.scss']
})


export class SingleActeurComponent implements OnInit {

  acteur: Acteur;
  acteurInfo:Observable<Acteur>
  persos: Observable<any[]>
  id
  constructor(private acteurService: ActeurService, private filmService: FilmService, private personnageService: PersonnageService, private route: ActivatedRoute, private routeur : Router, protected alertService: AlertService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.personnageService.getPersoByActeur(+this.id).then((res:any)=>{
      this.persos=of(res) 
    })
    this.acteurService.getActeurById(+this.id).then( (res:Acteur) =>{
      this.acteurInfo=of(res)       
    })
  }

  remove(perso){
    this.personnageService.removePerso(perso).subscribe(res =>{console.log(res)
      this.alertService.success('personnage supprimé')
      this.personnageService.getPersoByActeur(+this.id).then((res:any)=>{
        this.persos=of(res) 
      })
    })
  }

 

  update(perso){
    this.routeur.navigate(['/updatePerso', { noFilm: perso.noFilm, noAct: perso.noAct,nomPerso: perso.nomPerso} ]);
  }

}
