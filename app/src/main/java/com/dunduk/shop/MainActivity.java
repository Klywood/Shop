package com.dunduk.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    int price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
        createHashMap();
    }

    void createSpinner() {  //Метод для спиннера

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Cat");
        spinnerArrayList.add("Dog");
        spinnerArrayList.add("Hamster");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }
    void createHashMap(){  // Метод для списка
    goodsMap = new HashMap();
    goodsMap.put("Cat", 20);
    goodsMap.put("Dog", 35);
    goodsMap.put("Hamster", 7);

}
    public void plusOne(View view) {
        quantity = quantity + 1;
        TextView plusOneCount = findViewById(R.id.quantityCount);
        plusOneCount.setText("" + quantity);
        TextView priceText = findViewById(R.id.priceText);
        priceText.setText("" + quantity * price);
    }

    public void minOne(View view) {
        if (quantity <= 0) {
            quantity = 0;
        }
        else {
            quantity = quantity - 1;
        }
        TextView plusOneCount = findViewById(R.id.quantityCount);
        plusOneCount.setText("" + quantity);
        TextView priceText = findViewById(R.id.priceText);
        priceText.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (int) goodsMap.get(goodsName);
        TextView priceText = findViewById(R.id.priceText);
        priceText.setText("" + quantity * price);

        ImageView goodsImageView = findViewById(R.id.imageGoods);

        switch (goodsName){
            case "Cat":
                goodsImageView.setImageResource(R.drawable.cat);
                break;
            case "Dog":
                goodsImageView.setImageResource(R.drawable.dog);
                break;
            case "Hamster":
                goodsImageView.setImageResource(R.drawable.hamster);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.cat);
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}