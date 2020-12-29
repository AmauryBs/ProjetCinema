package com.webservice.projetcinema.model;

import javax.persistence.*;
import java.io.Serializable;


class CompositeKey implements Serializable {
    private Film film;
    private Acteur act;
}

@Entity
@IdClass(CompositeKey.class)
@Table(name = "personnage")
public class Personnage implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "NoFilm", columnDefinition="int(4) NOT NULL")
    private Film film;



    @Id
    @ManyToOne
    @JoinColumn(name = "NoAct", columnDefinition="int(4) NOT NULL")
    private Acteur act;

    @Basic
    @Column(name = "NomPers", columnDefinition="varchar(30) NOT NULL")
    private String NomPers;




    public Film getNoFilm(){ return this.film; }
    public Acteur getNoAct(){ return this.act; }

    public String getNomPers(){ return this.NomPers; }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setAct(Acteur act) {
        this.act = act;
    }

    public void setNomPers(String nomPers) {
        NomPers = nomPers;
    }

}
