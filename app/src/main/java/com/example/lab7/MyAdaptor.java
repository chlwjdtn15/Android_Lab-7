package com.example.lab7;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.ViewHolder> {

    List<User> users;

    MyAdaptor(List<User> users) {
        this.users = users;
    }


    @NonNull
    @Override
    public MyAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.recycler_view, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdaptor.ViewHolder holder, int position) {




        holder.name.setText(users.get(position).name);
        holder.rating.setRating(users.get(position).rating);

        String ratetv = String.valueOf(holder.rating.getRating());
        holder.rating_tv.setText("Rate " + ratetv);

        holder.comment_tv.setText(users.get(position).comment);



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Button EditCommentBTn;
        TextView name;
        RatingBar rating;
        TextView rating_tv;
        TextView comment_tv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.name_tv);

            rating = itemView.findViewById(R.id.ratingbar_recieve);

            rating_tv = itemView.findViewById(R.id.rating_tv);

            comment_tv = itemView.findViewById(R.id.comment_tv);

            EditCommentBTn = itemView.findViewById(R.id.commentBTn);

            EditCommentBTn.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {



            Intent intent = new Intent(v.getRootView().getContext(), activity_third.class);

            intent.putExtra("name", name.getText().toString());


            v.getContext().startActivity(intent);

        }
    }
}