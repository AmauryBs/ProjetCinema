package com.webservice.projetcinema.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "realisateur")
public class Realisateur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NoRea", columnDefinition="int(2) NOT NULL AUTO_INCREMENT",nullable = false, unique = true)
    private int NoRea;


    @Column(name = "NomRea", columnDefinition="varchar(20) NOT NULL")
    private String NomRea;


    @Column(name = "PrenRea", columnDefinition="varchar(20) NOT NULL")
    private String PrenRea;


    @OneToMany(mappedBy="rea")
    private List<Film> films = new ArrayList<Film>();



    public int getNoRea(){ return this.NoRea; }
    public String getNomRea(){ return this.NomRea; }

    public String getPrenRea(){ return this.PrenRea; }

    public void setNomReae(String NomRea) { this.NomRea = NomRea; }
    public void setPrenRea(String PrenRea) { this.PrenRea = PrenRea;}

}
