package com.example.flagapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    Button btn_main;
    ImageView img_flag;
    EditText country_name;
    int image_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (savedInstanceState != null) {
//            image_flag = savedInstanceState.getInt("image_key");
//            img_flag.setImageResource(image_flag);
//        }

        btn_main = findViewById(R.id.btn_main);
        img_flag = findViewById(R.id.imageView);
        country_name = findViewById(R.id.main_te1);
        country_name.addTextChangedListener(textEditWatcher);
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (country_name.getText().toString().toUpperCase()) {
                    case "РОССИЯ":
                        img_flag.setImageResource(R.drawable.flag_rf);
                        img_flag.setOnClickListener(imgListener);

                        break;
                    case "ТАИЛАНД":
                    case "ТАЙЛАНД":
                        img_flag.setImageResource(R.drawable.flag_thai);
                        break;
                    case "ЭСТОНИЯ":
                        img_flag.setImageResource(R.drawable.flag_est);
                        break;
                    case "ШВЕЦИЯ":
                        img_flag.setImageResource(R.drawable.flag_swed);
                        break;
                    case "ФИНЛЯНДИЯ":
                        img_flag.setImageResource(R.drawable.flag_fin);
                        break;
                    case "АБХАЗИЯ":
                        img_flag.setImageResource(R.drawable.flag_abh);
                        break;
                    case "КАМБОДЖА":
                        img_flag.setImageResource(R.drawable.flag_camb);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Тут я еще не был! А стоит ли?", LENGTH_SHORT)
                                .show();
                        img_flag.setImageResource(R.drawable.flag_grey_big);
                }

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("image_key", image_flag);
    }

    View.OnClickListener imgListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            intent.putExtra("country",country_name.getText().toString());
            startActivity(intent);
        }
    };
    TextWatcher textEditWatcher;

    {
        textEditWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                btn_main.setEnabled(!country_name.getText().toString().isEmpty());


//                if (!country_name.getText().toString().isEmpty()) {
//                    btn_main.setEnabled(true);
//                    btn_main.setBackgroundResource(R.drawable.btn_gradient);
//                } else {
//                    img_flag.setImageResource(R.drawable.flag_grey_big);
//                    btn_main.setEnabled(false);
//                    btn_main.setBackgroundResource(R.color.color_btn_disabled);


            }

        };
    }

}
