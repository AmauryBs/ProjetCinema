package com.webservice.projetcinema.repository;

import com.webservice.projetcinema.model.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Integer> {


    @Query("Select A.NoAct,A.NomAct,A.PrenAct,A.DateNaiss,A.DateDeces" +
            " from Acteur A" +
            " where A.NoAct=:noAct"
    )
    List<Acteur> findActeurById(int noAct);
}
