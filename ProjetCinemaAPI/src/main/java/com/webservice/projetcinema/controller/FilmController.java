package com.webservice.projetcinema.controller;

import com.webservice.projetcinema.model.Film;
import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getFilms/acteur/{nomAct}")
    public List<Film> findAllFilmsByActeur(@PathVariable(value = "nomAct") String nomAct) {
        String destinationPage = "";
        //System.out.println("nomAct : " + nomAct);
        List<Film> mesFilms = null;
        try {
            mesFilms = filmService.getAllFilmsByActeur(nomAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesFilms;
    }
}
