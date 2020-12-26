import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Acteur } from '../models/acteur.model';
import { ActeurService } from '../services/acteur.service';

@Component({
  selector: 'app-single-acteur',
  templateUrl: './single-acteur.component.html',
  styleUrls: ['./single-acteur.component.scss']
})
export class SingleActeurComponent implements OnInit {

  acteur: Acteur;

  constructor(private acteurService: ActeurService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.acteur = this.acteurService.getActeurById(+id);
  }

}
