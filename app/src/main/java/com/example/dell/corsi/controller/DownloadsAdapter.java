package com.example.dell.corsi.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dell.corsi.model.Downloads;
import com.example.dell.corsi.R;

import java.util.ArrayList;

public class DownloadsAdapter extends ArrayAdapter<Downloads> {

    public DownloadsAdapter(@NonNull Context context, ArrayList<Downloads> downloads) {
        super(context, 0, downloads);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Downloads downloads = getItem(position);
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.d_list_item,parent,false);
        }
        TextView name = (TextView) listItemView.findViewById(R.id.name_text_view);
        name.setText(downloads.getName());
        TextView description = (TextView) listItemView.findViewById(R.id.description_text_view);
        description.setText(downloads.getDescription());

        return listItemView;
    }
}
