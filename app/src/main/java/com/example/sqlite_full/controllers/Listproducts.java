package com.example.sqlite_full.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlite_full.R;
import com.example.sqlite_full.models.Helper;
import com.example.sqlite_full.models.Products;

import java.util.ArrayList;
import java.util.List;

public class Listproducts extends AppCompatActivity {

Helper helper=new Helper(this);
ListView list_view_products;
List<Products> allProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listproducts);

        //##########################################################
        list_view_products=findViewById(R.id.ListView_Products);

        allProducts=helper.getAllProducts();

        // listview adaptor called
        listviewadapter();

        // set on select item clicked
        list_view_products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView t=view.findViewById(R.id.id);

                Intent intent=new Intent(Listproducts.this, Details_product.class);
                intent.putExtra("id",t.getText().toString());
                startActivity(intent);


            }
        });

    }

    //###############################################################################################
    private void listviewadapter(){
        // set  adapter
        list_view_products.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return allProducts.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                // initialize view
                View view =getLayoutInflater().inflate(
                        R.layout.items,null
                );

                /// initialize main data
                Products data=allProducts.get(position);
                // initialize and assign variable
                TextView id =view.findViewById(R.id.id);
                TextView name =view.findViewById(R.id.name);
                TextView price=view.findViewById(R.id.price);

                // set on the text widgets
                id.setText(String.valueOf(data.getId()));
                name.setText(data.getNom());
                price.setText(String.valueOf(data.getPrix()));

                // return view
                return view;
            }
        });

    }



}