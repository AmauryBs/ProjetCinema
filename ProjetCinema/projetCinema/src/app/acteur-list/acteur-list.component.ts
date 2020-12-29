import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Acteur } from '../models/acteur.model';
import { ActeurService } from '../services/acteur.service';

@Component({
  selector: 'app-acteur-list',
  templateUrl: './acteur-list.component.html',
  styleUrls: ['./acteur-list.component.scss']
})
export class ActeurListComponent implements OnInit {

  acteurs: Acteur[];
  acteurSubscription: Subscription;

  constructor(private acteurService: ActeurService) { }

  ngOnInit() {
    this.acteurSubscription = this.acteurService.acteurSubject.subscribe(
      (acteurs: any[]) => {
        this.acteurs = acteurs;
      }
    );
    this.acteurService.getActeurs()
  }



}
