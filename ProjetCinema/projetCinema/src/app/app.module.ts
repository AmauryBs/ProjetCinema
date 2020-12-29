import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { FilmListComponent } from './film-list/film-list.component';
import { AuthService } from './services/auth.service';
import { AuthGuard } from './services/auth-guard.service';
import { FilmService } from './services/film.service';
import { ActeurService } from './services/acteur.service';


import { AuthComponent } from './auth/auth.component';

import { FourOhFourComponent } from './four-oh-four/four-oh-four.component';
import { SingleFilmComponent } from './single-film/single-film.component';
import { FilmComponent } from './film/film.component';
import { ActeurComponent } from './acteur/acteur.component';
import { ActeurListComponent } from './acteur-list/acteur-list.component';
import { SingleActeurComponent } from './single-acteur/single-acteur.component';
import { ModifPersoComponent } from './modif-perso/modif-perso.component';
import { AddPersoComponent } from './add-perso/add-perso.component';
import { AddPersoFilmComponent } from './add-perso-film/add-perso-film.component';
import { UpdatePersoFilmComponent } from './update-perso-film/update-perso-film.component';
import { PersonnageService } from './services/personnage.service';
import { SearchFilmComponent } from './search-film/search-film.component';
import {  HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    FilmListComponent,
    AuthComponent,
    FourOhFourComponent,
    FilmComponent,
    ActeurComponent,
    ActeurListComponent,
    SingleActeurComponent,
    SingleFilmComponent,
    ModifPersoComponent,
    AddPersoComponent,
    AddPersoFilmComponent,
    UpdatePersoFilmComponent,
    SearchFilmComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthService, AuthGuard,FilmService,ActeurService, PersonnageService],
  bootstrap: [AppComponent]
})
export class AppModule {}