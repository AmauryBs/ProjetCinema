package com.webservice.projetcinema.service;

import com.webservice.projetcinema.model.Film;
import com.webservice.projetcinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    private FilmRepository filmRepo;

    @Autowired
    public FilmService(FilmRepository filmRepo){
        this.filmRepo = filmRepo;
    }

    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }

    public List<Film> getAllFilmsByCat(String codeCat) {
        return filmRepo.getAllFilmsByCat(codeCat);
    }

    public List<Film> getAllFilmsByActeur(String nomAct, String prenAct) {
        return filmRepo.getAllFilmsByActeur(nomAct,prenAct);
    }

    public List<Film> getFilmById(int idFilm) {
        return filmRepo.getFilmById(idFilm);
    }

    public List<Film> getAllFilmsByTitle(String titre) {
        return filmRepo.getAllFilmsByTitle(titre);
    }

    public List<Film> getAllFilmsByRealisateur(String nomRea, String prenRea) {
        return filmRepo.getAllFilmsByRealisateur(nomRea,prenRea);
    }
}
