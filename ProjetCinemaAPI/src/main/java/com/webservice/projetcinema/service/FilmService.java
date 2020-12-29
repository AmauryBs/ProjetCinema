package com.webservice.projetcinema.service;

import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.model.Film;
import com.webservice.projetcinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class FilmService {
    private FilmRepository filmRepo;

    @Autowired
    public FilmService(FilmRepository filmRepo){
        this.filmRepo = filmRepo;
    }

    public List<Film> getAllFilms() {
        return this.filmRepo.findAll();
    }

    public List<Film> getAllFilmsByCat(String codeCat) {
        return this.filmRepo.getAllFilmsByCat(codeCat);
    }

    public List<Film> getAllFilmsByActeur(String nomAct, String prenAct) {
        return this.filmRepo.getAllFilmsByActeur(nomAct,prenAct);
    }

    public Film getFilmById(int idFilm) {
        return this.filmRepo.findById(idFilm).orElseThrow(
                () -> new MonException("Film", "id", idFilm)
        );
    }

    public List<Film> getAllFilmsByTitle(String titre) {
        return this.filmRepo.getAllFilmsByTitle(titre);
    }

    public List<Film> getAllFilmsByRealisateur(String nomRea, String prenRea) {
        return this.filmRepo.getAllFilmsByRealisateur(nomRea,prenRea);
    }

    public void addFilm( String titre, int duree, Date dateSortie, int budget, int montantRecette, int noRea, String codeCat) {
        System.out.println(" titre : " + titre+" duree : " + duree+" dateSortie : " + dateSortie+" budget : " + budget+" montantRecette : " + montantRecette+
                " noRea : " + noRea+
                " codeCat : " + codeCat);
        filmRepo.addFilm(titre,duree,dateSortie,budget,montantRecette,noRea,codeCat);
    }

    public void supprFilm(int noFilm) {
        this.filmRepo.supprFilm(noFilm);
    }

    public void updateFilm(String noFilm, String titre, int duree, Date dateSortie, int budget, int montantRecette, int noRea, String codeCat) {
        this.filmRepo.updateFilm(noFilm, titre, duree, dateSortie, budget,  montantRecette, noRea, codeCat);
    }
}
