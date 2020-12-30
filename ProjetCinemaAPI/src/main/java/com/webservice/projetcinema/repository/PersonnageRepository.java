package com.webservice.projetcinema.repository;

import com.webservice.projetcinema.model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Long> {


    @Query("Select P.act,P.NomPers " +
            " from Personnage P" +
            " join Acteur A on P.act.NoAct=A.NoAct"+
            " where A.NomAct =:nomAct"
    )
    List<Personnage> getAllPersonnagesOfActeurName(String nomAct);



    @Modifying
    @Query(value = " insert into Personnage (" +
            "NoFilm, NoAct, NomPers) VALUES (" +
            " (Select F.NoFilm from Film F where F.NoFilm=:noFilm), " +
            "(Select A.NoAct from Acteur A where A.NoAct=:noAct)," +
            ":nomPers)",
            nativeQuery = true)
    @Transactional
    void addPersWithParams(int noFilm, int noAct, String nomPers);

    @Modifying
    @Query(" DELETE FROM Personnage P" +
            " WHERE (P.film.NoFilm=:noFilm and P.act.NoAct=:noAct)")
    @Transactional
    void supprPers(int noFilm, int noAct);

    @Query(value= "Select P.NoFilm,P.NoAct,P.NomPers " +
            " from Personnage P" +
            " where P.NoAct=:noAct and P.NoFilm=:noFilm",nativeQuery = true
    )
    List<Personnage> getPersonnageFromIds(int noFilm, int noAct);



    @Query(value="Select P.NoAct,P.NoFilm,P.NomPers " +
            " from Personnage P" +
            " where P.NoFilm=:noFilm",nativeQuery = true
    )
    List<Personnage> getAllPersonnagesOfFilm(int noFilm);


    @Query(value ="Select P.NoAct,P.NoFilm,P.NomPers " +
            " from Personnage P" +
            " where P.NoAct=:noAct",nativeQuery = true
    )
    List<Personnage> getAllPersonnagesOfActeur(int noAct);
}
