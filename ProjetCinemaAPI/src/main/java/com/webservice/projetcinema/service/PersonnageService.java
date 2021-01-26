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

    public List<Personnage> getAllPersonnagesOfActeurName(String nomAct) {
        return persRepo.getAllPersonnagesOfActeurName(nomAct);
    }

    public void addPersonnageObjet(Personnage unPers) {
        this.persRepo.save(unPers);
    }

    public String addPersonnage(int noFilm, int noAct, String nomPers) {
        Personnage pers = this.getPersonnageFromIds(noFilm, noAct);
        if(pers.getNoFilm().equals(null) && pers.getNoAct().equals(null) && pers.getNomPers().equals(null))
        {
            this.persRepo.addPersWithParams(noFilm, noAct,nomPers);
            return "Insert success";
        }
        else
        {
            return "Already exists";
        }

    }

    public void supprPersonnageObjet(Personnage unPers) {
        this.persRepo.delete(unPers);
    }

    public String supprPersonnage(int noFilm, int noAct) {
        Personnage pers = this.getPersonnageFromIds(noFilm, noAct);
        if(pers.getNoFilm().getNoFilm()!=0 && pers.getNoAct().getNoAct()!=0 && pers.getNomPers()!="")
        {
            this.persRepo.supprPers(noFilm, noAct);
            return "Delete success";
        }
        else
        {
            return "Not found";
        }

    }

    public String updatePersonnage(int noFilmOld, int noActOld, int noFilm, int noAct, String nomPers) {
        Personnage pers = this.getPersonnageFromIds(noFilm, noAct);
        if(!pers.getNoFilm().equals(null) && !pers.getNoAct().equals(null) && !pers.getNomPers().equals(null))
        {
            this.persRepo.supprPers(noFilmOld, noActOld);
            this.persRepo.addPersWithParams(noFilm, noAct,nomPers);
            return "Update Success";
        }
        else
        {
            this.persRepo.addPersWithParams(noFilm, noAct,nomPers);
            return "Not Found, Inserted";
        }

    }

    public Personnage getPersonnageFromIds(int noFilm, int noAct) {
        return this.persRepo.getPersonnageFromIds(noFilm,noAct);
    }

    public List<Personnage> getAllPersonnagesOfFilm(int noFilm) {
        return this.persRepo.getAllPersonnagesOfFilm(noFilm);
    }

    public List<Personnage> getAllPersonnagesOfActeur(int noAct) {
        return persRepo.getAllPersonnagesOfActeur(noAct);
    }
}
