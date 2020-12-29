import { Component, Input, OnInit } from '@angular/core';
import { ActeurService } from '../services/acteur.service';

@Component({
  selector: 'app-acteur',
  templateUrl: './acteur.component.html',
  styleUrls: ['./acteur.component.scss']
})
export class ActeurComponent implements OnInit {

  @Input() nom: string;
  @Input() prenom: string;
  @Input() dateNaiss: Date;
  @Input() dateDeces: Date;

  @Input() id: number;
  
  constructor() { }

  ngOnInit(): void {
  }

}
