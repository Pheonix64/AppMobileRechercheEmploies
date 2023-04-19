package sn.esmt.examendevmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import sn.esmt.examendevmobile.databinding.ActivityListCvBinding;

public class ListCvActivity extends AppCompatActivity {

    ActivityListCvBinding binding;
    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListCvBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //les users
        users =  (ArrayList<User>) getIntent().getSerializableExtra("users");

        ListCvAdapter listCvAdapter = new ListCvAdapter(ListCvActivity.this, users);

        binding.listCvView.setAdapter(listCvAdapter);
        binding.listCvView.setClickable(true);
        binding.listCvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListCvActivity.this, UserCv.class);

                i.putExtra("nom",users.get(position).getNom());
                i.putExtra("prenom",users.get(position).getPrenom());
                i.putExtra("age", users.get(position).getAge());
                i.putExtra("email",users.get(position).getEmail());
                i.putExtra("adresse",users.get(position).getAdresse());
                i.putExtra("telephone",users.get(position).getTelephone());
                i.putExtra("specialite",users.get(position).getSpecialite());
                i.putExtra("niveauEtude",users.get(position).getNiveauEtude());
                i.putExtra("experienceProf",users.get(position).getExperienceProfessionnelle());

                startActivity(i);
            }
        });
    }
}