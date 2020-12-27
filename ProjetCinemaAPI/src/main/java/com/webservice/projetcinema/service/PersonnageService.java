package com.webservice.projetcinema.service;

import com.webservice.projetcinema.model.Personnage;
import com.webservice.projetcinema.repository.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnageService {

    private PersonnageRepository persRepo;

    @Autowired
    public PersonnageService(PersonnageRepository persRepo){
        this.persRepo = persRepo;
    }

    public List<Personnage> getAllPersonnages() {
        return persRepo.findAll();
    }

    public List<Personnage> getAllPersonnagesOfActeur(String nomAct) {
        return persRepo.getAllPersonnagesOfActeur(nomAct);
    }

    public void addPersonnageObjet(Personnage unPers) {
        this.persRepo.save(unPers);
    }

    public void addPersonnage(int noFilm,int noAct, String nomPers) {
        this.persRepo.addPersWithParams(noFilm, noAct,nomPers);
    }

    public void supprPersonnageObjet(Personnage unPers) {
        this.persRepo.delete(unPers);
    }

    public void supprPersonnage(int noFilm, int noAct) {
        this.persRepo.supprPers(noFilm, noAct);
    }
}
