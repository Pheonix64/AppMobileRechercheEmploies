package sn.esmt.examendevmobile;

import android.graphics.Bitmap;

import java.io.Serializable;

public class User implements Serializable {
    private String nom, prenom, adresse, email, telephone;
    private  String specialite,  niveauEtude, experienceProfessionnelle;
    private int age;
    /*
    *
    *
    * "id": 0,
  "nom": "string",
  "prenom": "string",
  "email": "string",
  "adresse": "string",
  "specialite": "string",
  "age": 0,
  "telephone": "string",
  "niveauEtude": "string",
  "experienceProfessionnelle": "string"
    * */

    public User(String nom, String prenom, String email, String adresse, String specialite, int age, String telephone, String niveauEtude, String experienceProfessionnelle) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.specialite = specialite;
        this.niveauEtude = niveauEtude;
        this.experienceProfessionnelle = experienceProfessionnelle;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public String getExperienceProfessionnelle() {
        return experienceProfessionnelle;
    }

    public int getAge() {
        return age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public void setExperienceProfessionnelle(String experienceProfessionnelle) {
        this.experienceProfessionnelle = experienceProfessionnelle;
    }

    public void setAge(int age) {
        this.age = age;
    }
}