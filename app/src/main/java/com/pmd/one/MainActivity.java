package com.pmd.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    TextView quantityTextView;
    ImageView goodsImageView;
    Spinner spinner;
    EditText userNameEditText;
    ArrayList spinnerArrayList = new ArrayList();
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.nameEditText);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList.add("guitar black");
        spinnerArrayList.add("guitar red");
        spinnerArrayList.add("guitar blue");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("guitar black", 1000.0);
        goodsMap.put("guitar red", 750.0);
        goodsMap.put("guitar blue", 2000.0);

    }

    public void increaseQuantity(View view) {
        quantity++;
        quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    public void decreaseQuantity(View view) {
        quantity--;
        quantity = (quantity < 0) ? (quantity = 0) : quantity;
        quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);

        goodsImageView = findViewById(R.id.goodsImageView);

        if ("guitar black".equals(goodsName)) {
            goodsImageView.setImageResource(R.drawable.guitar);
        } else if ("guitar red".equals(goodsName)){
            goodsImageView.setImageResource(R.drawable.guitar_red);
        } else if ("guitar blue".equals(goodsName)) {
            goodsImageView.setImageResource(R.drawable.guitar_blue);
        } else {
            goodsImageView.setImageResource(R.drawable.problem);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void addToCard(View view) {
        Order order = new Order(userNameEditText.getText().toString(),
                goodsName,
                quantity,
                price,
                quantity * price);
        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra(Order.class.getSimpleName(), order);
        startActivity(orderIntent);
    }
}