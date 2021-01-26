package com.webservice.projetcinema.controller;

import com.webservice.projetcinema.model.Acteur;
import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class ActeurController {

    @Autowired
    private ActeurService actService;


    public ActeurController(ActeurService actService){
        this.actService = actService;
    }

    @GetMapping("/getActeurs")
    public List<Acteur> findAllActeurs() {
        List<Acteur> mesActeurs = null;
        try {
            mesActeurs = actService.getAllActeurs();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesActeurs;
    }

    @GetMapping("/getActeur/{noAct}")
    public Acteur findActeurById(@PathVariable(value = "noAct") int noAct) {
        Acteur mesActeurs = null;
        try {
            mesActeurs = actService.getActeurById(noAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesActeurs;
    }
}
