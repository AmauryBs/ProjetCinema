package com.webservice.projetcinema.repository;

import com.webservice.projetcinema.model.Categorie;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{


}
