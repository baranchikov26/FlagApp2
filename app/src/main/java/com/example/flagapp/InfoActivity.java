package com.example.flagapp;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        country = Objects.requireNonNull(getIntent().getExtras()).getString("country");

        Toast.makeText(InfoActivity.this, country, Toast.LENGTH_LONG)
                .show();
        assert country != null;
        if (country.equals("Россия")) {
            items.add(new Item(getResources().getStringArray(R.array.ru_taxt)[0], R.drawable.ru1));
            items.add(new Item(getResources().getStringArray(R.array.ru_taxt)[1], R.drawable.ru2));
            items.add(new Item(getResources().getStringArray(R.array.ru_taxt)[2], R.drawable.ru1));
            items.add(new Item(getResources().getStringArray(R.array.ru_taxt)[3], R.drawable.ru2));
            items.add(new Item(getResources().getStringArray(R.array.ru_taxt)[4], R.drawable.ru1));


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
