package com.webservice.projetcinema.service;


import com.webservice.projetcinema.model.Realisateur;
import com.webservice.projetcinema.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {
    private RealisateurRepository reaRepo;

    @Autowired
    public RealisateurService(RealisateurRepository reaRepo){
        this.reaRepo = reaRepo;
    }

    public List<Realisateur> getAllRealiateurs() {
        return reaRepo.findAll();
    }
}
