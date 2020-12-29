package com.webservice.projetcinema.controller;


import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.model.Categorie;
import com.webservice.projetcinema.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class CategorieController {

    @Autowired
    private CategorieService catService;


    public CategorieController(CategorieService services){
        this.catService = services;
    }

    @GetMapping("/getCategories")
    public List<Categorie> findAllCategories() {
        String destinationPage = "";
        List<Categorie> mesCategories = null;
        try {
            mesCategories = catService.getAllCategories();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesCategories;
    }

}
