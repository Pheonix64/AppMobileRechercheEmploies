package sn.esmt.examendevmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import sn.esmt.examendevmobile.databinding.ActivityUserCvBinding;

public class UserCv extends AppCompatActivity {

    ActivityUserCvBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserCvBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String nom = intent.getStringExtra("nom");
            String prenom = intent.getStringExtra("prenom");
            String age = String.valueOf(intent.getIntExtra("age",18));
            String email = intent.getStringExtra("email");
            String telephone = intent.getStringExtra("telephone");
            String adresse = intent.getStringExtra("adresse");
            String specialite = intent.getStringExtra("specialite");
            String niveauEtude = intent.getStringExtra("niveauEtude");
            String experienceProf = intent.getStringExtra("experienceProf");

            binding.nomProfile.setText(nom + " " + prenom);
            binding.nameSpecialite.setText(specialite);
            binding.userAge.setText(age);
            binding.userEmail.setText(email);
            binding.userPhone.setText(telephone);
            binding.userAddress.setText(adresse);
            binding.userStudyLevel.setText(niveauEtude);
            binding.userExperience.setText(experienceProf);

        }
    }
}