package com.webservice.projetcinema.repository;

import com.webservice.projetcinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {



    @Query("Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.rea,F.DateSortie,F.cat " +
            " from Film F"+
            " where  F.cat.CodeCat LIKE %:codeCat%"
    )
    List<Film> getAllFilmsByCat(String codeCat);


    @Query("Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.DateSortie,F.cat,F.rea " +
            " from Film F" +
            " join Personnage P on P.film.NoFilm=F.NoFilm" +
            " join Acteur A on P.act.NoAct=A.NoAct"+
            " where A.NomAct LIKE %:nomAct% and A.PrenAct LIKE %:prenAct%"
    )
    List<Film> getAllFilmsByActeur(String nomAct,String prenAct);


    @Query("Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.DateSortie,F.cat,F.rea " +
            " from Film F" +
            " where F.NoFilm=:idFilm"
    )
    List<Film> getFilmById(int idFilm);


    @Query("Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.DateSortie,F.cat,F.rea " +
            " from Film F" +
            " where F.Titre LIKE %:titre%"
    )
    List<Film> getAllFilmsByTitle(String titre);


    @Query("Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.DateSortie,F.cat,F.rea " +
            " from Film F" +
            " join Realisateur R on R.NoRea =F.rea.NoRea" +
            " where R.NomRea LIKE %:nomRea% and R.PrenRea LIKE %:prenRea%"
    )
    List<Film> getAllFilmsByRealisateur(String nomRea, String prenRea);
}