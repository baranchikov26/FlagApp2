package com.example.flagapp;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfoActivity extends AppCompatActivity {

    String country;
    RecyclerView recyclerView;
    ItemsAdapter itemsAdapter;
    List<Item> items = new ArrayList<>();
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        country = Objects.requireNonNull(getIntent().getExtras()).getString("country");
        preferences = getPreferences(MODE_PRIVATE);
        country = preferences.getString("country", "страна");

        assert country != null;
        switch (country.toUpperCase()) {
            case "РОССИЯ":
            items.add(new Item(getResources().getStringArray(R.array.ru_text)[0], R.drawable.ru1));
            items.add(new Item(getResources().getStringArray(R.array.ru_text)[1], R.drawable.ru2));
            items.add(new Item(getResources().getStringArray(R.array.ru_text)[2], R.drawable.ru3));
                break;
            case "ТАИЛАНД":
            case "ТАЙЛАНД":
                items.add(new Item(getResources().getStringArray(R.array.thai_text)[0], R.drawable.thai1));
                items.add(new Item(getResources().getStringArray(R.array.thai_text)[1], R.drawable.thai2));
                items.add(new Item(getResources().getStringArray(R.array.thai_text)[2], R.drawable.thai3));
                break;
            case "ЭСТОНИЯ":
                items.add(new Item(getResources().getStringArray(R.array.est_text)[0], R.drawable.est1));
                items.add(new Item(getResources().getStringArray(R.array.est_text)[1], R.drawable.est2));
                items.add(new Item(getResources().getStringArray(R.array.est_text)[2], R.drawable.est3));
                break;
            case "ШВЕЦИЯ":
                items.add(new Item(getResources().getStringArray(R.array.swed_text)[0], R.drawable.swed1));
                items.add(new Item(getResources().getStringArray(R.array.swed_text)[1], R.drawable.swed2));
                items.add(new Item(getResources().getStringArray(R.array.swed_text)[2], R.drawable.swed3));
                break;
            case "ФИНЛЯНДИЯ":
                items.add(new Item(getResources().getStringArray(R.array.fin_text)[0], R.drawable.fin1));
                items.add(new Item(getResources().getStringArray(R.array.fin_text)[1], R.drawable.fin2));
                items.add(new Item(getResources().getStringArray(R.array.fin_text)[2], R.drawable.fin3));
                break;
            case "АБХАЗИЯ":
                items.add(new Item(getResources().getStringArray(R.array.abh_text)[0], R.drawable.abh1));
                items.add(new Item(getResources().getStringArray(R.array.abh_text)[1], R.drawable.abh2));
                items.add(new Item(getResources().getStringArray(R.array.abh_text)[2], R.drawable.abh3));
                break;
            case "КАМБОДЖА":
                items.add(new Item(getResources().getStringArray(R.array.camb_text)[0], R.drawable.camb1));
                items.add(new Item(getResources().getStringArray(R.array.camb_text)[1], R.drawable.camb2));
                items.add(new Item(getResources().getStringArray(R.array.camb_text)[2], R.drawable.camb3));
                break;
            case "ЕГИПЕТ":
                items.add(new Item(getResources().getStringArray(R.array.egpt_text)[0], R.drawable.egpt1));
                items.add(new Item(getResources().getStringArray(R.array.egpt_text)[1], R.drawable.egpt2));
                items.add(new Item(getResources().getStringArray(R.array.egpt_text)[2], R.drawable.egpt3));
                break;
            case "ЛАТВИЯ":
                items.add(new Item(getResources().getStringArray(R.array.latv_text)[0], R.drawable.latv1));
                items.add(new Item(getResources().getStringArray(R.array.latv_text)[1], R.drawable.latv2));
                items.add(new Item(getResources().getStringArray(R.array.latv_text)[2], R.drawable.latv3));
                break;
            case "ДНР":
                items.add(new Item(getResources().getStringArray(R.array.dnr_text)[0], R.drawable.dnr1));
                items.add(new Item(getResources().getStringArray(R.array.dnr_text)[1], R.drawable.dnr2));
                items.add(new Item(getResources().getStringArray(R.array.dnr_text)[2], R.drawable.dnr3));
                break;
        }
        recyclerView = findViewById(R.id.recycler);
        itemsAdapter = new ItemsAdapter();

        recyclerView.setAdapter(itemsAdapter);
        itemsAdapter.setItems(items);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            layoutManager.setOrientation(LinearLayout.VERTICAL);
        } else {
            layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        }
        recyclerView.setLayoutManager(layoutManager);
    }

}
