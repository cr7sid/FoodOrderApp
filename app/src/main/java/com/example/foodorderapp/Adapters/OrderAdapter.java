package com.example.foodorderapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodorderapp.Models.OrderModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    ArrayList<OrderModel> models;
    Context context;

    public OrderAdapter(ArrayList<OrderModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_ordered_item, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       final OrderModel model = models.get(position);

        holder.tvOrderNumber.setText(model.getOrderNumber());
        holder.tvItemPrice.setText(model.getItemPrice());
        holder.orderedItemImage.setImageResource(model.getItemImage());
        holder.tvItemName.setText(model.getItemName());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView orderedItemImage;
        TextView tvItemName, tvItemPrice, tvOrderNumber;;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            orderedItemImage = itemView.findViewById(R.id.orderItemImage);
            tvItemName = itemView.findViewById(R.id.orderItemName);
            tvOrderNumber = itemView.findViewById(R.id.orderItemNumber);
            tvItemPrice = itemView.findViewById(R.id.orderItemPrice);


        }

    }

}
