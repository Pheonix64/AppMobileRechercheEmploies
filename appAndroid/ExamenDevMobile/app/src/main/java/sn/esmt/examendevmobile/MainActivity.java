package sn.esmt.examendevmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sn.esmt.examendevmobile.interfaceApi.Api;
import sn.esmt.examendevmobile.interfaceApi.RetrofitClient;

public class MainActivity extends AppCompatActivity {

    private Button cvBnt;
    GridLayout gridLayout;

    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ajoutez cet appel pour supprimer la barre de titre
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //Les offres d'emploi par categorie
        gridLayout = (GridLayout) findViewById(R.id.categorieOffreId);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View childView = gridLayout.getChildAt(i);
            childView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, OffreEmploiActivity.class);
                    startActivity(intent);
                }
            });
        }

        //Les differentes cv
        cvBnt = (Button) findViewById(R.id.cvBnt);
        cvBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserFromApi();
            }
        });

    }

    private void getUserFromApi() {
        Api api = RetrofitClient.getClient().create(Api.class);
        Call<ArrayList<User>> call = api.all();

        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if (response.isSuccessful()) {

                    Intent intent = new Intent(MainActivity.this, ListCvActivity.class);
                    response.body().stream().forEach(user -> users.add(user));
                    intent.putExtra("users",users);// Envoyer les données vers ListCvActivity
                    startActivity(intent);
                } else {
                        // Afficher un message d'erreur si la requête n'a pas aboutie
                        Toast.makeText(MainActivity.this, "Erreur: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                // Afficher un message d'erreur en cas d'échec de l'appel
                Toast.makeText(MainActivity.this, "Erreur: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}