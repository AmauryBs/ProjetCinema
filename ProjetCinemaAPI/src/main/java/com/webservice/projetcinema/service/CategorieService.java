package com.webservice.projetcinema.service;

import com.webservice.projetcinema.model.Categorie;
import com.webservice.projetcinema.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategorieService {
    private CategorieRepository catRepo;


    @Autowired
    public CategorieService(CategorieRepository catRepo){
        this.catRepo = catRepo;
    }

    public List<Categorie> getAllCategories() {
        return catRepo.findAll();
    }
}
