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
            " where  F.cat = ( Select C.CodeCat from Categorie C where C.CodeCat LIKE %:codeCat%)"
    )
    List<Film> getAllFilmsByCat(String codeCat);


    @Query("Select F.NoFilm,F.Titre,A.NomAct,A.PrenAct,F.Budget,F.Duree,F.MontantRecette,F.DateSortie,F.cat,F.rea " +
            " from Film F" +
            " join Personnage P on P.film.NoFilm=F.NoFilm" +
            " join Acteur A on P.act.NoAct=A.NoAct"+
            " where A.NomAct =:nomAct or A.PrenAct =:nomAct"
    )
    List<Film> getAllFilmsByActeur(String nomAct);
}