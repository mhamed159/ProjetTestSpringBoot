package com.mhamedbaguenne.projetSpringBoot.model;

import org.hibernate.sql.Insert;

import javax.jws.WebMethod;

public class InsertionEmployee {


    String name;
    private Employee Employee;

    public InsertionEmployee() {

    }
        @WebMethod
        public void insert (String prenom, String nom,String adresse, String numero) {

        Employee.setPrenom(prenom);
        Employee.setNom(nom);
        Employee.setAdresse(adresse);
        Employee.setNuméro(numero);



        }

}
