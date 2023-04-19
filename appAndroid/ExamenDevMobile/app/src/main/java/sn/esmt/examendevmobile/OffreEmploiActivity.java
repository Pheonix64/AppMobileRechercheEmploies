package sn.esmt.examendevmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OffreEmploiActivity extends AppCompatActivity {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> offreCollection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offre_emploi);
        createGroupList();
        createCollection();

        expandableListView = findViewById(R.id.listOffreView);
        expandableListAdapter = new ListOffreAdapter(this, groupList, offreCollection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;
            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedPosition != -1 && i != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String selected = expandableListAdapter.getChild(i, i1).toString();
                Toast.makeText(getApplicationContext(), "Selected: " + selected, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void createCollection() {
        String[] ingElect = {"Nous recherchons un chef de projet informatique expérimenté pour gérer des projets de développement de logiciels et de systèmes d'information.postuler.",
                "Profile Recherché: Avoir un diplôme universitaire en génie électrique ou expérience équivalente avec 2 ans d'expérience",
                "Date limite: 02/10/2022"};

        offreCollection = new HashMap<String, List<String>>();
        for (String group : groupList) {
            if (group.equals("Ingénieur en énergie électrique")) {
                loadChild(ingElect);
            } else if (group.equals("Google"));

            offreCollection.put(group, childList);
        }
    }

    private void loadChild(String[] offreModels) {
        childList = new ArrayList<>();
        for (String model : offreModels) {
            childList.add(model);
        }
    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("Ingénieur en énergie électrique");
        groupList.add("Technicien en énergie électrique");
        groupList.add("Responsable de projet en énergie électrique");
        groupList.add("Électromécanicien en énergie électrique");
    }
}
