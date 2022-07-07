package com.example.sqlite_full.models;

public class Products {
    public int getId() {
        return id;
    }

    public Products(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Products(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Products() {

    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    int id;
    String nom;
    double prix;


}
