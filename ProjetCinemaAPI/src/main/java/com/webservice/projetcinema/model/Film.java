package com.webservice.projetcinema.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "film")
public class Film implements Serializable {
    @Id
    @Column(name = "NoFilm", columnDefinition="int(4) NOT NULL AUTO_INCREMENT",nullable = false, unique = true)
    private int NoFilm;

    @Basic
    @Column(name = "Titre", columnDefinition="varchar(30) NOT NULL")
    private String Titre;

    @Basic
    @Column(name = "Duree", columnDefinition="int(3) NOT NULL")
    private int Duree;

    @Basic
    @Column(name = "DateSortie", columnDefinition="int(3) NOT NULL")
    private Date DateSortie;

    @Basic
    @Column(name = "Budget", columnDefinition="int(8) NOT NULL")
    private int Budget;

    @Basic
    @Column(name = "MontantRecette", columnDefinition="int(8) NOT NULL")
    private int MontantRecette;

    @ManyToOne
    @JoinColumn(name = "NoRea", columnDefinition="int(2) NOT NULL")
    private Realisateur rea;

    @ManyToOne
    @JoinColumn(name = "CodeCat", columnDefinition="varchar(2) NOT NULL")
    private Categorie cat;

    public int getNoFilm(){ return this.NoFilm; }
    public String getTitre(){return this.Titre;}
    public int getDuree() {
        return this.Duree;
    }
    public Date getDateSortie() { return this.DateSortie; }
    public int getBudget() { return this.Budget; }
    public int getMontantRecette() { return this.MontantRecette; }
    public Realisateur getRea() { return this.rea; }
    public Categorie getCat() { return this.cat; }

    public void setTitre(String Titre) { this.Titre = Titre; }
    public void setDuree(int Duree) { this.Duree = Duree;}
    public void setDateSortie(Date DateSortie) { this.DateSortie = DateSortie;}
    public void setBudget(int Budget) { this.Budget = Budget;}
    public void setMontantRecette(int MontantRecette) { this.MontantRecette = MontantRecette;}
    public void setNoRea(Realisateur Rea) { this.rea = Rea;}
    public void setCodeCat(Categorie Cat) { this.cat = Cat; }
}
