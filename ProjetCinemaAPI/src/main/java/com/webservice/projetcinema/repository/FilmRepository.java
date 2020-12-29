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