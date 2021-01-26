package com.webservice.projetcinema.controller;

import com.webservice.projetcinema.model.Film;
import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.model.Personnage;
import com.webservice.projetcinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class FilmController {

    @Autowired
    private FilmService filmService;


    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping("/getFilms")
    public List<Film> findAllFilms() {
        List<Film> mesFilms = null;
        try {
            mesFilms = filmService.getAllFilms();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesFilms;
    }

    @PostMapping("/getFilms/cat")
    public List<Film> findAllFilmsByCat(@RequestParam("libelleCat") String libelleCat) {
        List<Film> mesFilms = null;
        try {
            mesFilms = filmService.getAllFilmsByCat(libelleCat);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesFilms;
    }

    @PostMapping("/getFilms/acteur")
    public List<Film> findAllFilmsByActeur(@RequestParam("nomOrPrenAct") String nomOrPrenAct) {
        List<Film> mesFilms = null;
        try {
            mesFilms = filmService.getAllFilmsByActeur(nomOrPrenAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesFilms;
    }

    @GetMapping("/getFilm/{idFilm}")
    public Film findFilmById(@PathVariable(value = "idFilm") int idFilm) {
        Film monFilm = null;
        try {
            monFilm =  filmService.getFilmById(idFilm);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return monFilm;
    }

    @PostMapping("/getFilms/titre")
    public List<Film> findFilmById(@RequestParam("titre") String titre) {
        List<Film> mesFilms = null;
        try {
            mesFilms = filmService.getAllFilmsByTitle(titre);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesFilms;
    }

    @PostMapping("/getFilms/realisateur")
    public List<Film> findAllFilmsByRealisateur(@RequestParam("nomOrPrenRea") String nomOrPrenRea) {
        List<Film> mesFilms = null;
        try {
            mesFilms = filmService.getAllFilmsByRealisateur(nomOrPrenRea);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesFilms;
    }


    @PostMapping("/ajoutFilm")
    public void ajouterUnFilm(
                                    @RequestParam("titre") String titre,
                                    @RequestParam("duree") int duree,
                                    @RequestParam("dateSortie") Date dateSortie,
                                    @RequestParam("budget") int budget,
                                    @RequestParam("montantRecette") int montantRecette,
                                    @RequestParam("noRea") int noRea,
                                    @RequestParam("codeCat") String codeCat
                                    ) {
        try {
           filmService.addFilm(titre,duree,dateSortie,budget,montantRecette,noRea,codeCat);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/supprFilm")
    public void supprUnPersonnage(@RequestParam("noFilm") int noFilm) {
        try {
            filmService.supprFilm(noFilm);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/modifFilm")
    public void updateFilm(
                                    @RequestParam("noFilm") String noFilm,
                                    @RequestParam("titre") String titre,
                                    @RequestParam("duree") int duree,
                                    @RequestParam("dateSortie") Date dateSortie,
                                    @RequestParam("budget") int budget,
                                    @RequestParam("montantRecette") int montantRecette,
                                    @RequestParam("noRea") int noRea,
                                    @RequestParam("codeCat") String codeCat)
    {
        try {
            filmService.updateFilm(noFilm, titre, duree, dateSortie, budget,  montantRecette, noRea, codeCat);
        }
        catch (MonException e) {

            ResponseEntity.notFound().build();
        }
        catch (Exception e) {

            ResponseEntity.notFound().build();
        }

    }
}
