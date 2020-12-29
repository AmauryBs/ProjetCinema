package com.webservice.projetcinema.service;

import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.model.Acteur;
import com.webservice.projetcinema.repository.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActeurService {
    private ActeurRepository actRepo;


    @Autowired
    public ActeurService(ActeurRepository actRepo){
        this.actRepo = actRepo;
    }

    public List<Acteur> getAllActeurs() {
        return actRepo.findAll();
    }

    public Acteur getActeurById(int noAct) {
        return this.actRepo.findById(noAct).orElseThrow(
                () -> new MonException("Acteur", "id", noAct)
        );
    }
}
