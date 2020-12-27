package com.webservice.projetcinema.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "acteur")
public class Acteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NoAct",columnDefinition="int(2) NOT NULL AUTO_INCREMENT", unique = true, updatable = false)
    private int NoAct;

    @Basic
    @Column(name = "NomAct", columnDefinition="varchar(20) DEFAULT NULL")
    private String NomAct;


    @Basic
    @Column(name = "PrenAct",columnDefinition="varchar(20) DEFAULT NULL")
    private String PrenAct;

    @Basic
    @Column(name = "DateNaiss",columnDefinition="date DEFAULT NULL")
    private Date DateNaiss;

    @Basic
    @Column(name = "DateDeces",columnDefinition="date DEFAULT NULL")
    private Date DateDeces;

    public int getNoAct(){
        return this.NoAct;
    }

    public String getNomAct() {
        return NomAct;
    }

    public String getPrenAct() {
        return PrenAct;
    }

    public Date getDateNaiss() {
        return DateNaiss;
    }

    public Date getDateDeces() {
        return DateDeces;
    }

    public void setDateNaiss(Date DateNaiss) {
        this.DateNaiss = DateNaiss;
    }

    public void setDateDeces(Date DateDeces) {
        this.DateDeces = DateDeces;
    }

    public void setNomAct(String NomAct) {
        this.NomAct = NomAct;
    }

    public void setLPrenAct(String PrenAct) {
        this.PrenAct = PrenAct;
    }

}
