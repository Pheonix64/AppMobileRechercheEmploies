package sn.esmt.examenDevMobile.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usercv")
public class AppCVEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20, nullable = false, unique = true)
    private String nom;
    private String prenom;
    private  String email;
    private  String adresse;
    private  String specialite;
    private int age;
    private String telephone;
    private String niveauEtude;
    private String experienceProfessionnelle;

}
