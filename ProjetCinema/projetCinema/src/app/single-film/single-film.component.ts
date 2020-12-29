import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Film } from '../models/film.model';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';

@Component({
  selector: 'app-single-film',
  templateUrl: './single-film.component.html',
  styleUrls: ['./single-film.component.scss']
})
export class SingleFilmComponent implements OnInit {

  film: Film;
  displayedColumns: string[] = ['titre', 'perso', 'action'];
  acteur
  persos
  constructor(private filmService: FilmService, private personnageService: PersonnageService,
    private route: ActivatedRoute, private acteurService: ActeurService) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.film = this.filmService.getFilmById(+id);
    
    this.persos = this.personnageService.getPersoByFilm(+id)
    for(var perso of this.persos){
      perso["nomAct"] =this.acteur =this.acteurService.getActeurById(perso.noAct).prenAct + " " + this.acteurService.getActeurById(perso.noAct).nomAct
    }
  }

  remove(perso){
    this.personnageService.removePerso(perso)
  }
}
