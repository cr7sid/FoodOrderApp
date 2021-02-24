package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityItemDetailsBinding;

public class ItemDetailsActivity extends AppCompatActivity {

    ActivityItemDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityItemDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);

        Intent intent = getIntent();

        if(intent.getIntExtra("type",0) == 1) {

            final int image = intent.getIntExtra("image", 0);
            final int price = Integer.parseInt(intent.getStringExtra("price"));
            final String foodName = intent.getStringExtra("name");
            final String description = intent.getStringExtra("description");

            Log.i("Blah", String.format("%d", image));

            binding.detailItemName.setText(foodName);
            binding.detailItemDescription.setText(description);
            binding.detailItemPrice.setText(String.format("%d", price));
            binding.detailItemImage.setImageResource(image);

            binding.btnOrder.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    boolean isInserted = helper.insertOrder(
                            binding.userName.getText().toString(),
                            binding.userPhone.getText().toString(),
                            Integer.parseInt(binding.itemQuantity.getText().toString()),
                            price,
                            image,
                            description,
                            foodName
                    );

                    if(isInserted) {

                        Toast.makeText(ItemDetailsActivity.this, "Data Added!", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(ItemDetailsActivity.this, "Data Not Added!", Toast.LENGTH_SHORT).show();

                    }
                }
            });

        } else {

            int id = getIntent().getIntExtra("id", 0);

            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(5);

            binding.btnOrder.setText("UPDATE ORDER");
            binding.detailItemImage.setImageResource(image);
            binding.detailItemName.setText(cursor.getString(7));
            binding.detailItemDescription.setText(cursor.getString(2));
            binding.detailItemPrice.setText(String.format("%d", cursor.getInt(3)));
            binding.userName.setText(cursor.getString(1));
            binding.userPhone.setText(cursor.getString(6));

            binding.btnOrder.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    boolean isUpdated = helper.updateOrder(
                            binding.userName.getText().toString(),
                            binding.userPhone.getText().toString(),
                            Integer.parseInt(binding.itemQuantity.getText().toString()),
                            Integer.parseInt(binding.detailItemPrice.getText().toString()),
                            image,
                            binding.detailItemDescription.getText().toString(),
                            binding.detailItemName.getText().toString(),
                            id
                    );

                    if(isUpdated) {

                        Toast.makeText(ItemDetailsActivity.this, "Success!", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(ItemDetailsActivity.this, "Failed!", Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }

    }
}