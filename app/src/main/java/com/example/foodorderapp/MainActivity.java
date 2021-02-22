package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> mainModels = new ArrayList<>();

        mainModels.add(new MainModel(R.drawable.burger, "Burger", "Burger hai yeh", "5"));
        mainModels.add(new MainModel(R.drawable.pizza, "Pizza", "Pizza hai yeh", "10"));
        mainModels.add(new MainModel(R.drawable.burger, "Chicken", "Chicken hai yeh", "15"));
        mainModels.add(new MainModel(R.drawable.pizza, "Nuggets", "Nuggets hai yeh", "20"));
        mainModels.add(new MainModel(R.drawable.burger, "Main", "Main hai yeh", "25"));

        MainAdapter adapter = new MainAdapter(mainModels, this);

        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

    }



}