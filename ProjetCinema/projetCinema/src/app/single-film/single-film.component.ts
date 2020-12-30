import { ArrayType } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Acteur } from '../models/acteur.model';
import { Film } from '../models/film.model';
import { Personnage } from '../models/personnage.model';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';

@Component({
  selector: 'app-single-film',
  templateUrl: './single-film.component.html',
  styleUrls: ['./single-film.component.scss']
})
export class SingleFilmComponent implements OnInit {
  filmInfo:Observable<Film>;
  displayedColumns: string[] = ['titre', 'perso', 'action'];
  persos: Observable<any[]>
  id

  constructor(private filmService: FilmService, private personnageService: PersonnageService,
    private route: ActivatedRoute, private acteurService: ActeurService,private router: Router,) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];

    this.personnageService.getPersoByFilm(+this.id).then( (res:any) =>{
      this.persos=of(res)       
    })

    this.filmService.getFilmById(+this.id).then( (res:Film) =>{
      this.filmInfo=of(res)       
    })
  }

  remove(perso){
    this.personnageService.removePerso(perso).subscribe(res =>{console.log(res)
      this.personnageService.getPersoByFilm(+this.id).then((res:any)=>{
        this.persos=of(res)
        this.router.navigate(["/films/"+res[0].noFilm.noFilm]);
      })
    })


  }
}
