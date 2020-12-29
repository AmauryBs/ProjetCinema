import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { FourOhFourComponent } from './four-oh-four/four-oh-four.component';
import { AuthGuard } from './services/auth-guard.service';
import { FilmListComponent } from './film-list/film-list.component';
import { SingleFilmComponent } from './single-film/single-film.component';
import { ActeurListComponent } from './acteur-list/acteur-list.component';
import { SingleActeurComponent } from './single-acteur/single-acteur.component';
import { ModifPersoComponent } from './modif-perso/modif-perso.component';
import { AddPersoComponent } from './add-perso/add-perso.component';
import { AddPersoFilmComponent } from './add-perso-film/add-perso-film.component';
import { UpdatePersoFilmComponent } from './update-perso-film/update-perso-film.component';


const appRoutes: Routes = [
  { path: 'auth', component: AuthComponent },
  { path: 'films', canActivate: [AuthGuard],component: FilmListComponent },
  { path: 'films/:id', canActivate: [AuthGuard],component: SingleFilmComponent },
  { path: 'acteurs', canActivate: [AuthGuard],component: ActeurListComponent },
  { path: 'acteurs/:id', canActivate: [AuthGuard],component:SingleActeurComponent },
  { path: 'updatePerso/:noFilm/:noAct/:nomPerso', canActivate: [AuthGuard],component:ModifPersoComponent },
  { path: 'updatePersoFilm/:noFilm/:noAct/:nomPerso', canActivate: [AuthGuard],component:UpdatePersoFilmComponent },
  { path: 'addPerso/:id', canActivate: [AuthGuard],component:AddPersoComponent },
  { path: 'addPersoFilm/:id', canActivate: [AuthGuard],component:AddPersoFilmComponent },  
  { path: '', canActivate: [AuthGuard],component:  FilmListComponent},
  { path: 'not-found', component: FourOhFourComponent },
  { path: '**', redirectTo: 'not-found' },

];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
