package com.example.thmoviesapp.softwareproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Abed Eid on 03/05/2016.
 */
public class Gadwal_adpter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> Items;
    String m;


    public Gadwal_adpter(Context context, List<String> Items) {
        this.context = context;
        this.Items = Items;

    }

    @Override
    public int getCount() {
        return Items.size();
    }

    @Override
    public Object getItem(int location) {
        return Items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.gadwal_item, parent, false);
        TextView username = (TextView) convertView.findViewById(R.id.Dg_name);
        TextView Subject = (TextView) convertView.findViewById(R.id.Dg_subject_gadwal);
        TextView time = (TextView) convertView.findViewById(R.id.Dg_time);
        TextView begain = (TextView) convertView.findViewById(R.id.Dg_Begin_time);
        TextView end = (TextView) convertView.findViewById(R.id.Dg_End_time);
        TextView place = (TextView) convertView.findViewById(R.id.Dg_place);
        m = Items.get(position);
        String[] parts = (m.split(" doctor"));
        username.setText(parts[0]);
        String[] part = parts[1].split("Subject ");
        Subject.setText(part[0].toString());
        String[] par = part[1].split("begin");
        begain.setText(par[0]);
        String[] pa = par[1].split("end");
        end.setText(pa[0]);
        time.setText("" + (Double.parseDouble(pa[0]) - Double.parseDouble(par[0])));
        String[] p1 = pa[1].split("place");
        place.setText(p1[0]);
        return convertView;
    }


}
