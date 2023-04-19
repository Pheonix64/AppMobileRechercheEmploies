package sn.esmt.examendevmobile;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import sn.esmt.examendevmobile.R;
import sn.esmt.examendevmobile.User;

public class ListCvAdapter extends BaseAdapter {

    private ArrayList<User> users;
    private LayoutInflater myInflater;

    public ListCvAdapter(Context context, ArrayList<User> users)
    {
        this.myInflater = LayoutInflater.from(context);
        this.users = users;
    }

    @Override
    public int getCount() {
        return this.users.size();
    }

    @Override
    public Object getItem(int arg0) {
        return this.users.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {

        TextView userName;
        TextView userSpecialite;
        CircleImageView profile_image;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null)
        {
            convertView = myInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.userName = (TextView) convertView.findViewById(R.id.userName);
            holder.userSpecialite = (TextView) convertView.findViewById(R.id.userSpecialite);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.userSpecialite.setText(users.get(position).getSpecialite());
        holder.userName.setText(users.get(position).getNom() + " " + users.get(position).getPrenom());

        return convertView;

    }

}
