package sn.esmt.examendevmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sn.esmt.examendevmobile.interfaceApi.Api;
import sn.esmt.examendevmobile.interfaceApi.RetrofitClient;

public class PostulerActivity extends AppCompatActivity {

    EditText postulerNomId, postulerPrenomId, postulerAgeId, postulerEmailId;
   private EditText postulerPhoneId, postulerAdresseId, postulerNiveauId, postulerSpecialiteId, postulerExpId;
    private Button envoyerBnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postuler);

        // Créer une instance de Retrofit
        Api api = RetrofitClient.getClient().create(Api.class);

        postulerNomId = findViewById(R.id.nomId);
        postulerPrenomId = findViewById(R.id.prenomId);
        postulerAgeId = findViewById(R.id.ageId);
        postulerEmailId = findViewById(R.id.emailId);
        postulerPhoneId = findViewById(R.id.prenomId);
        postulerAdresseId = findViewById(R.id.adresseId);
        postulerNiveauId = findViewById(R.id.niveauId);
        postulerSpecialiteId = findViewById(R.id.specialiteId);
        postulerExpId = findViewById(R.id.experienceId);

        envoyerBnt = findViewById(R.id.envoyerBnt);

//        EditText[] widget = {postulerNomId,postulerPrenomId,postulerAgeId,postulerEmailId,
//        postulerPhoneId,postulerAdresseId,postulerNiveauId,postulerSpecialiteId,postulerExpId};
//
//        for(int i=0; i<widget.length; i++){
//            int finalI = i;
//            widget[i].setOnEditorActionListener((v, actionId, event) -> {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    String name = widget[finalI].getText().toString();
//                    if (name.isEmpty()) {
//                        widget[finalI].setError("Le champ est requis");
//                        envoyerBnt.setEnabled(false);
//                        return false;
//                    }
//                    else {
//                        envoyerBnt.setEnabled(true);
//                    }
//                }
//                return true;
//            });
//        }

    // Ajouter un OnClickListener sur le bouton
    envoyerBnt.setOnClickListener(v -> {
        // Récupérer les informations de l'utilisateur depuis les champs de saisie

        String nom = postulerNomId.getText().toString();
        String prenom = postulerPrenomId.getText().toString();
        String intValue = postulerAgeId.getText().toString();
        String email = postulerEmailId.getText().toString();
        String phone = postulerPhoneId.getText().toString();
        String adresse = postulerAdresseId.getText().toString();
        String niveau = postulerNiveauId.getText().toString();
        String specialite = postulerSpecialiteId.getText().toString();
        String experience = postulerExpId.getText().toString();

        int age;
        try {
            age = Integer.parseInt(intValue);
        } catch (NumberFormatException e) {
            age = 18;
        }

        // Créer une instance de User avec les informations de l'utilisateur
        User user = new User(nom, prenom, email, adresse, specialite, age, phone, niveau, experience);
        // Appeler la méthode createUser() de MyApi en utilisant l'instance de User
        Call<User> call = api.createUser(user);

        // Exécuter l'appel de manière asynchrone
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // Traitement de la réponse
                if (response.isSuccessful()) {
                   // Toast.makeText(PostulerActivity.this, "Données envoyées avec succès!", Toast.LENGTH_SHORT).show();
                    postulerNomId.setText("");
                    postulerPrenomId.setText("");
                    postulerAgeId.setText("");
                    postulerEmailId.setText("");
                    postulerPhoneId.setText("");
                    postulerAdresseId.setText("");
                    postulerNiveauId.setText("");
                    postulerSpecialiteId.setText("");
                    postulerExpId.setText("");
                    LayoutInflater inflater = LayoutInflater.from(PostulerActivity.this);
                    View dialogView = inflater.inflate(R.layout.retour_postuler, null);

                    AlertDialog.Builder builder = new AlertDialog.Builder(PostulerActivity.this);
                    builder.setView(dialogView);
                    final AlertDialog dialog = builder.create();
                    dialog.show();

                    Button okButton = dialogView.findViewById(R.id.dialog_ok_button);
                    okButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent intent = new Intent(PostulerActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                    return;
                }
                User userResponse = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(PostulerActivity.this, "Echec de l'opération!", Toast.LENGTH_SHORT).show();
            }
        });
    });
    }
}