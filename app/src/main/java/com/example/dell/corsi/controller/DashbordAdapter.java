package com.example.dell.corsi.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.corsi.model.Dashbord;
import com.example.dell.corsi.R;

import java.util.ArrayList;

public class DashbordAdapter extends RecyclerView.Adapter<DashbordAdapter.DashbordviewHolder> {

    ArrayList<Dashbord>dashbords;
    public DashbordAdapter (ArrayList<Dashbord>dashbord){
        dashbords = dashbord;
    }
    @NonNull
    @Override
    public DashbordAdapter.DashbordviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.dashbord_list_item, viewGroup, false);
        DashbordviewHolder dashbordviewHolder = new DashbordviewHolder(view);


        return dashbordviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashbordviewHolder dashbordviewHolder, int i) {
        dashbordviewHolder.name.setText(dashbords.get(i).getName());
        dashbordviewHolder.imageView.setImageResource(dashbords.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return dashbords.size();
    }

    public class DashbordviewHolder extends RecyclerView.ViewHolder {

        ImageView imageView ;
        TextView name;

        public DashbordviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_dashBoard);
            name = (TextView) itemView.findViewById(R.id.name_dashBoard);
        }
    }
}
