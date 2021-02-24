package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.orderPage:
                startActivity(new Intent(MainActivity.this, OrderedItemActivity.class));
                break;

        }


        return super.onOptionsItemSelected(item);
    }

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