import { Component, Input, OnInit } from '@angular/core';
import { FilmService } from '../services/film.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.scss']
})
export class FilmComponent implements OnInit {

  @Input() titre: string;
  @Input() realisateur: string;
  @Input() duree: number;
  @Input() dateSortie: Date;
  @Input() genre: string;
  @Input() id: number;
  
  constructor(private filmService: FilmService) { }

  ngOnInit(): void {
  }

}
