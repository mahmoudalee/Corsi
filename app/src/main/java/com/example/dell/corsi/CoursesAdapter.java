package com.example.dell.corsi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {
    final private ListItemClickListener mOnClickListener;

    ArrayList<Courses> courses;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public CoursesAdapter(ArrayList<Courses> course ,  ListItemClickListener listener){
        courses=course;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public CoursesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.courses_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesAdapter.ViewHolder viewHolder, int i) {
        viewHolder.imageView.setImageResource(courses.get(i).getImage());
        viewHolder.mName.setText(courses.get(i).getName());
        viewHolder.mDiscription.setText(courses.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        ImageView imageView;
        TextView mName;
        TextView mDiscription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name_course_view);
            mDiscription = itemView.findViewById(R.id.description_course_view);
            imageView = itemView.findViewById(R.id.image_course_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickPosition);
        }
    }
}
