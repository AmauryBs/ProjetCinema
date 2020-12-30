package com.webservice.projetcinema.repository;

import com.webservice.projetcinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {



    @Query(value = "Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.rea,F.DateSortie,F.cat " +
            " from Film F"+
            " where  F.LibelleCat LIKE %:libelleCat%",nativeQuery = true
    )
    List<Film> getAllFilmsByCat(String libelleCat);


    @Query(value="Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.DateSortie,F.cat,F.rea " +
            " from Film F" +
            " join Personnage P on P.film.NoFilm=F.NoFilm" +
            " join Acteur A on P.act.NoAct=A.NoAct"+
            " where A.NomAct LIKE %:nomOrPrenAct% or A.PrenAct LIKE %:nomOrPrenAct%",nativeQuery = true
    )
    List<Film> getAllFilmsByActeur(String nomOrPrenAct);


    @Query("Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.DateSortie,F.cat,F.rea " +
            " from Film F" +
            " where F.NoFilm=:idFilm"
    )
    List<Film> getFilmById(int idFilm);


    @Query(value = "Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.DateSortie,F.cat,F.rea " +
            " from Film F" +
            " where F.Titre LIKE %:titre%",nativeQuery = true
    )
    List<Film> getAllFilmsByTitle(String titre);


    @Query(value="Select F.NoFilm,F.Titre,F.Budget,F.Duree,F.MontantRecette,F.DateSortie,F.CodeCat,F.NoRea " +
            " from Film F" +
            " join Realisateur R on R.NoRea =F.NoRea" +
            " where R.NomRea LIKE %:nomOrPrenRea% or R.PrenRea LIKE %:nomOrPrenRea%",
            nativeQuery = true
    )
    List<Film> getAllFilmsByRealisateur(String nomOrPrenRea);


    @Modifying
    @Query(value = " insert into Film(" +
            "Titre, Duree, DateSortie, Budget, MontantRecette,NoRea,CodeCat) VALUES (" +
            ":titre," +
            ":duree," +
            ":dateSortie," +
            ":budget," +
            ":montantRecette," +
            " (Select R.NoRea from Realisateur R where R.NoRea=:noRea), " +
            " (Select C.CodeCat from Categorie C where C.CodeCat LIKE %:codeCat%)" +
            ")",
            nativeQuery = true)
    /*insert into Film(Titre, Duree, DateSortie, Budget, MontantRecette,NoRea,CodeCat) VALUES ("Lucy",150,1988-05-05,2000000,5200000,(SELECT NoRea From realisateur where NoRea=1),(SELECT CodeCat From categorie where CodeCat="AC"))*/
    @Transactional
    void addFilm( String titre, int duree, Date dateSortie, int budget, int montantRecette, int noRea, String codeCat);


    @Modifying
    @Query(" DELETE FROM Film F" +
            " WHERE F.NoFilm=:noFilm")
    @Transactional
    void supprFilm(int noFilm);



    @Modifying
    @Query(value = " UPDATE Film " +
            "SET Titre =:titre," +
            " Duree =:duree, " +
            " DateSortie =:dateSortie," +
            " Budget =:budget," +
            " MontantRecette =:montantRecette," +
            " NoRea =(Select R.NoRea from Realisateur R where R.NoRea=:noRea)," +
            " CodeCat=(Select C.CodeCat from Categorie C where C.CodeCat LIKE %:codeCat%)"+
            "WHERE NoFilm =:noFilm ",
            nativeQuery = true)
    @Transactional
    void updateFilm(String noFilm, String titre, int duree, Date dateSortie, int budget, int montantRecette, int noRea, String codeCat);
}