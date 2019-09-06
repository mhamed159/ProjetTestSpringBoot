package com.mhamedbaguenne.projetSpringBoot.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String prenom;
    private String nom;
    private String adresse;
    private String numero;

    public Employee() {

    }

    public Employee(long id, String nom, String prenom, String adresse, String numero ) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNuméro() {
        return numero;
    }

    public void setNuméro(String numéro) {
        this.numero = numéro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}