package com.webservice.projetcinema.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webservice.projetcinema.exceptions.MonException;
import com.webservice.projetcinema.model.Personnage;
import com.webservice.projetcinema.service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public Personnage findPersonnageFromIds(@RequestParam("noFilm") int noFilm,@RequestParam("noAct") int noAct) {
        Personnage monPersos = null;
        try {
            monPersos = persService.getPersonnageFromIds(noFilm,noAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return monPersos;
    }

    @GetMapping("/getPersonnages/acteur/name/{nomAct}")
    public List<Personnage> findAllPersonnagesOfActeurName(@PathVariable(value = "nomAct") String nomAct) {
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

    @PostMapping("/ajoutPersonnage")
    public HashMap<String, String> ajouterUnPersonnage(@RequestParam("noFilm") int noFilm, @RequestParam("noAct") int noAct, @RequestParam("nomPers") String nomPers) {
        String resp = "Error!";
        HashMap<String, String> jsonLike = new HashMap<>();
        try {
            resp = persService.addPersonnage(noFilm,noAct,nomPers);

        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        jsonLike.put("message", resp);
        return jsonLike;
    }

    @PostMapping("/supprPersonnage")
    public HashMap<String, String> supprUnPersonnage(@RequestParam("noFilm") int noFilm, @RequestParam("noAct") int noAct) {
        String resp = "Error !";
        HashMap<String, String> jsonLike = new HashMap<>();
        try {
            resp = persService.supprPersonnage(noFilm,noAct);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        jsonLike.put("message", resp);
        return jsonLike;
    }


    @PutMapping("/modifPersonnage")
    public HashMap<String, String> updatePersonnage(@RequestParam("noFilmOld") int noFilmOld, @RequestParam("noActOld") int noActOld, @RequestParam("noFilm") int noFilm, @RequestParam("noAct") int noAct, @RequestParam("nomPers") String nomPers)
    {
        String resp = "Error !";
        HashMap<String, String> jsonLike = new HashMap<>();

        try {

            resp = persService.updatePersonnage(noFilmOld,noActOld,noFilm,noAct,nomPers);
        }
        catch (MonException e) {

            ResponseEntity.notFound().build();
        }
        catch (Exception e) {

            ResponseEntity.notFound().build();
        }
        jsonLike.put("message", resp);
        return jsonLike;
    }
}
