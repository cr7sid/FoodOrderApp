package com.example.foodorderapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<MainModel> mainModels;
    Context context;

    public MainAdapter(ArrayList<MainModel> mainModels, Context context) {
        this.mainModels = mainModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_fooditem, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final MainModel model = mainModels.get(position);

        holder.foodImage.setImageResource(model.getImage());
        holder.tvName.setText(model.getName());
        holder.tvDescription.setText(model.getDescription());
        holder.tvPrice.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {

        return mainModels.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView tvName, tvPrice, tvDescription;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            foodImage = itemView.findViewById(R.id.food_img);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvDescription = itemView.findViewById(R.id.tv_description);

        }
    }

}
