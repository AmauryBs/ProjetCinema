package com.webservice.projetcinema.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodeCat", nullable = false, unique = true)
    private String CodeCat;

    @Basic
    @Column(name = "LibelleCat", nullable = false, length = 20)
    private String LibelleCat;

    @Basic
    @Column(name = "image",columnDefinition="varchar(200) NOT NULL", length = 200)
    private String image;

    @OneToMany(mappedBy="cat")
    private List<Film> films = new ArrayList<Film>();

    public String getCodeCat(){
        return this.CodeCat;
    }

    public String getLibelleCat() {
        return this.LibelleCat;
    }

    public String getimage() {
        return this.image;
    }

    public void setCodeCat(String CodeCat) {
        this.CodeCat = CodeCat;
    }

    public void setLibelleCat(String LibelleCat) {
        this.LibelleCat = LibelleCat;
    }

    public void setimage(String image) { this.image = image; }

}
