package sn.esmt.examendevmobile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ListOffreAdapter extends BaseExpandableListAdapter {


    private Context context;
    private Map<String, List<String>> offreCollection;
    private List<String> groupList;

    public ListOffreAdapter(Context context, List<String> groupList,
                                   Map<String, List<String>> offreCollection){
        this.context = context;
        this.offreCollection = offreCollection;
        this.groupList = groupList;
    }


    @Override
    public int getGroupCount() {
        return offreCollection.size() ;
    }

    @Override
    public int getChildrenCount(int i) {
        return offreCollection.get(groupList.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return offreCollection.get(groupList.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String offreName = getGroup(i).toString();
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.offre_emploi, null);
        }

        TextView item = view.findViewById(R.id.titreId);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(offreName);

        return view;
    }

    @Override
    public View getChildView(final int i,final int i1, boolean b, View view, ViewGroup viewGroup) {
        String descript = getChild(i, i1).toString();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_offre, null);

        }
        Button postuler = view.findViewById(R.id.postulerBnt);
        if (i >=0  && i1 !=2){
            postuler.setVisibility(View.GONE);
        }
        else {
            postuler.setVisibility(View.VISIBLE);
        }
        TextView descriptI = view.findViewById(R.id.descriptId);


        descriptI.setText(descript);
        postuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), PostulerActivity.class);
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}