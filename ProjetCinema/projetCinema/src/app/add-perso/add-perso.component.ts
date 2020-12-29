import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ActeurService } from '../services/acteur.service';
import { FilmService } from '../services/film.service';
import { PersonnageService } from '../services/personnage.service';

@Component({
  selector: 'app-add-perso',
  templateUrl: './add-perso.component.html',
  styleUrls: ['./add-perso.component.scss']
})
export class AddPersoComponent implements OnInit {

  constructor(private acteurService:ActeurService, private personnageService: PersonnageService, private filmService: FilmService, private router: Router, private route: ActivatedRoute) { }
  acteurInfo
  films
  ngOnInit(): void {
    this.films =this.filmService.getFilmList()
    const noAct = this.route.snapshot.params['id'];
    this.acteurInfo = this.acteurService.getActeurById(+noAct)
  }
  onSubmit(form: NgForm) {
    this.personnageService.addPerso(form.value)
    this.router.navigate(["/acteurs/"+this.acteurInfo.noAct]);
  }
}
