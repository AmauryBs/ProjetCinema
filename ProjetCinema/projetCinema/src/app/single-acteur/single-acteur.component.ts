import { Component, OnInit, ViewChild  } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Acteur } from '../models/acteur.model';
import { ActeurService } from '../services/acteur.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-single-acteur',
  templateUrl: './single-acteur.component.html',
  styleUrls: ['./single-acteur.component.scss']
})


export class SingleActeurComponent implements OnInit {

  acteur: Acteur;
  films
  displayedColumns: string[] = ['titre', 'perso', 'action'];

  constructor(private acteurService: ActeurService, private route: ActivatedRoute, private routeur : Router) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.acteur = this.acteurService.getActeurById(+id);
    this.films = this.acteurService.getPersoByActeur(+id)
  }

  remove(film){
    this.acteurService.removePerso(film)
  }

  add(){
    //this.acteurService.add()
  }

  update(film){
    this.routeur.navigate(['/updatePerso/'+ film.noFilm+ '.' + film.noAct + '.' + film.nomPerso]);
  }

}
