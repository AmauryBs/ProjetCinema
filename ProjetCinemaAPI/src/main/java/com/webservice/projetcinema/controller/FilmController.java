package com.webservice.projetcinema.controller;

import com.webservice.projetcinema.model.Film;
import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class FilmController {

    @Autowired
    private FilmService filmService;


    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping("/getFilms")
    public List<Film> findAllFilms() {
        String destinationPage = "";
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

    @GetMapping("/getFilms/cat/{codeCat}")
    public List<Film> findAllFilmsByCat(@PathVariable(value = "codeCat") String codeCat) {
        String destinationPage = "";
        System.out.println("codeCat : " + codeCat);
        List<Film> mesFilms = null;
        try {
            mesFilms = filmService.getAllFilmsByCat(codeCat);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesFilms;
    }

    @PostMapping("/getFilms/acteur")
    public List<Film> findAllFilmsByActeur(@RequestParam("nomAct") String nomAct,@RequestParam("prenAct") String prenAct) {
        String destinationPage = "";
        //System.out.println("nomAct : " + nomAct);
        List<Film> mesFilms = null;
        try {
            mesFilms = filmService.getAllFilmsByActeur(nomAct,prenAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesFilms;
    }

    @GetMapping("/getFilm/{idFilm}")
    public List<Film> findFilmById(@PathVariable(value = "idFilm") int idFilm) {
        String destinationPage = "";
        System.out.println("idFilm : " + idFilm);
        List<Film> monFilm = null;
        try {
            monFilm = filmService.getFilmById(idFilm);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return monFilm;
    }

    @GetMapping("/getFilms/{titre}")
    public List<Film> findFilmById(@PathVariable(value = "titre") String titre) {
        String destinationPage = "";
        System.out.println("titre : " + titre);
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
    public List<Film> findAllFilmsByRealisateur(@RequestParam("nomRea") String nomRea,@RequestParam("prenRea") String prenRea) {
        String destinationPage = "";
        //System.out.println("nomAct : " + nomAct);
        List<Film> mesFilms = null;
        try {
            mesFilms = filmService.getAllFilmsByRealisateur(nomRea,prenRea);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesFilms;
    }
}
