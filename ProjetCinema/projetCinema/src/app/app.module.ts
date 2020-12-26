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
    SingleFilmComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [AuthService, AuthGuard,FilmService,ActeurService],
  bootstrap: [AppComponent]
})
export class AppModule {}