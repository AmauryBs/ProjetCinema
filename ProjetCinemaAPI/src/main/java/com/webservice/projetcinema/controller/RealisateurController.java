package com.webservice.projetcinema.controller;

import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.model.Realisateur;

import com.webservice.projetcinema.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")

public class RealisateurController {

    @Autowired
    private RealisateurService reaService;


    public RealisateurController(RealisateurService reaService){
        this.reaService = reaService;
    }

    @GetMapping("/getRealisateurs")
    public List<Realisateur> findAllRealiateurs() {
        List<Realisateur> mesRealisateurs = null;
        try {
            mesRealisateurs = reaService.getAllRealiateurs();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesRealisateurs;
    }
}
