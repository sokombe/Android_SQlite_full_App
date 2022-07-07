package com.example.sqlite_full.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlite_full.R;
import com.example.sqlite_full.models.Helper;
import com.example.sqlite_full.models.Products;

public class MainActivity extends AppCompatActivity {
EditText name,price;
    Button button_save;
    Helper helper=new Helper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.Edit_Name_product);
        price=findViewById(R.id.Edit_product_price);
        button_save=findViewById(R.id.Button_Save_poduct);

        button_save.setOnClickListener(v -> {

            if(!name.getText().toString().isEmpty() && !price.getText().toString().isEmpty()){

                Products products=new Products(name.getText().toString(),Double.valueOf(price.getText().toString()));
                helper.insertProduct(products);

                Intent intent=new  Intent(this,Listproducts.class);
                startActivity(intent);

            }

        });

    }
}