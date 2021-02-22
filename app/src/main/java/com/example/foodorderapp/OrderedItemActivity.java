package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.foodorderapp.Adapters.OrderAdapter;
import com.example.foodorderapp.Models.OrderModel;
import com.example.foodorderapp.Models.OrderModel;
import com.example.foodorderapp.databinding.ActivityOrderedItemBinding;

import java.util.ArrayList;

public class OrderedItemActivity extends AppCompatActivity {
    
    ActivityOrderedItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderedItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrderModel> orderModels = new ArrayList<>();

        orderModels.add(new OrderModel(R.drawable.burger, "Burger", "5", "5235435"));
        orderModels.add(new OrderModel(R.drawable.pizza, "Pizza", "10", "1234230"));
        orderModels.add(new OrderModel(R.drawable.burger, "Chicken", "15", "1353425"));
        orderModels.add(new OrderModel(R.drawable.pizza, "Nuggets", "20", "22434230"));
        orderModels.add(new OrderModel(R.drawable.burger, "Main", "25", "223425"));

        OrderAdapter adapter = new OrderAdapter(orderModels, this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        
    }
}