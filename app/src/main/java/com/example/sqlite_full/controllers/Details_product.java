package com.example.sqlite_full.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.sqlite_full.R;
import com.example.sqlite_full.models.Dialog;
import com.example.sqlite_full.models.Helper;
import com.example.sqlite_full.models.Products;

import org.w3c.dom.Text;

public class Details_product extends AppCompatActivity {
    Helper helper=new Helper(this);
    TextView name,price;
    Button modif,supp;
    Dialog dialog=new Dialog(Details_product.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_product);

        name=findViewById(R.id.Edit_name_detail);
        price=findViewById(R.id.Edit_price_detail);
        modif=findViewById(R.id.button_modif_detail4);
        supp=findViewById(R.id.button_suprrime_detail);

        Products product=helper.getOneProduct(Integer.parseInt(getIntent().getStringExtra("id")));
        name.setText(product.getNom().toString());
        price.setText(String.valueOf(product.getPrix()));


        modif.setOnClickListener(v -> {

           // Products prod= new Products(Integer.parseInt(getIntent().getStringExtra("id"))
                //    ,name.getText().toString(),
                //    Double.valueOf(price.getText().toString()));

          //  helper.updateproduct(prod);

         //   Intent intent=new Intent(this,Listproducts.class);
       //     startActivity(intent);
            dialog.dialogBegin("Veuillez Patienter svp...",true);

        });

        supp.setOnClickListener(v -> {

           // helper.deleteproduct(Integer.parseInt(getIntent().getStringExtra("id")));

           // Intent intent=new Intent(this,Listproducts.class);
          //  startActivity(intent);
        dialog.dialogClose();
        });


    }
}