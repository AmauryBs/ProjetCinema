package com.webservice.projetcinema.controller;

import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.model.Personnage;
import com.webservice.projetcinema.service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class PersonnageController {

    @Autowired
    private PersonnageService persService;


    public PersonnageController(PersonnageService persService){
        this.persService = persService;
    }

    @GetMapping("/getPersonnages")
    public List<Personnage> findAllPersonnages() {
        String destinationPage = "";
        List<Personnage> mesPersos = null;
        try {
            mesPersos = persService.getAllPersonnages();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesPersos;
    }

    @PostMapping("/getPersonnageFromIds")
    public List<Personnage> findPersonnageFromIds(@RequestParam("noFilm") int noFilm,@RequestParam("noAct") int noAct) {
        String destinationPage = "";
        List<Personnage> mesPersos = null;
        try {
            mesPersos = persService.getPersonnageFromIds(noFilm,noAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesPersos;
    }

    @GetMapping("/getPersonnages/acteur/name/{nomAct}")
    public List<Personnage> findAllPersonnagesOfActeurName(@PathVariable(value = "nomAct") String nomAct) {
        String destinationPage = "";
        List<Personnage> mesPersos = null;
        try {
            mesPersos = persService.getAllPersonnagesOfActeurName(nomAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesPersos;
    }

    @GetMapping("/getPersonnages/film/{noFilm}")
    public List<Personnage> findAllPersonnagesOfFilm(@PathVariable(value = "noFilm") int noFilm) {
        String destinationPage = "";
        List<Personnage> mesPersos = null;
        try {
            mesPersos = persService.getAllPersonnagesOfFilm(noFilm);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesPersos;
    }

    @GetMapping("/getPersonnages/acteur/{noAct}")
    public List<Personnage> findAllPersonnagesOfActeur(@PathVariable(value = "noAct") int noAct) {
        String destinationPage = "";
        List<Personnage> mesPersos = null;
        try {
            mesPersos = persService.getAllPersonnagesOfActeur(noAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesPersos;
    }
    @PostMapping("/ajoutPersonnageObjet")
    public void ajouterUnPersonnage(@RequestBody Personnage unPers) {
        String destinationPage = "";
        try {
            persService.addPersonnageObjet(unPers);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/ajoutPersonnage")
    public void ajouterUnPersonnage(@RequestParam("noFilm") int noFilm,@RequestParam("noAct") int noAct,@RequestParam("nomPers") String nomPers) {
        String destinationPage = "";
        System.out.println("noFilm="+noFilm+" noAct:"+noAct+" nomPers:"+nomPers);
        try {
            persService.addPersonnage(noFilm,noAct,nomPers);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/supprPersonnageObjet")
    public void supprUnPersonnage(@RequestBody Personnage unPers) {
        String destinationPage = "";
        try {
            persService.supprPersonnageObjet(unPers);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/supprPersonnage")
    public void supprUnPersonnage(@RequestParam("noFilm") int noFilm,@RequestParam("noAct") int noAct) {
        String destinationPage = "";
        System.out.println("noFilm="+noFilm+" noAct:"+noAct);
        try {
            persService.supprPersonnage(noFilm,noAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/modifPersonnage")
    public void updatePersonnage(@RequestParam("noFilm") int noFilm,@RequestParam("noAct") int noAct,@RequestParam("nomPers") String nomPers)
    {
        try {
            persService.updatePersonnage(noFilm,noAct,nomPers);
        }
        catch (MonException e) {

            ResponseEntity.notFound().build();
        }
        catch (Exception e) {

            ResponseEntity.notFound().build();
        }

    }
}
