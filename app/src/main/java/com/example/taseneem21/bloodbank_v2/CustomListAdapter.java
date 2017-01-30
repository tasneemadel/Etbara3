package com.example.taseneem21.bloodbank_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by taseneem 21 on 11/27/2016.
 */
public class CustomListAdapter extends BaseAdapter {


    private ArrayList<Hospital> arrayList;
    private Context ctx;

    public CustomListAdapter(ArrayList<Hospital> arrayList, Context ctx) {
        this.arrayList = arrayList;
        this.ctx = ctx;
    }

    public void addItem(Hospital t)
    {
        arrayList.add(t);
        notifyDataSetChanged();
    }

    public void removeItem(int position)
    {
        arrayList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Hospital getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(R.layout.child_list,parent,false);

        TextView nameText = (TextView) convertView.findViewById(R.id.hospitalName);
        TextView descText = (TextView) convertView.findViewById(R.id.hospitalDesc);

        final Hospital t = getItem(position);

        nameText.setText(t.getHospitalname());
        descText.setText(t.getHospitalDescription());



        return convertView;
    }
}
