package com.example.castro_week3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ImageView planetimg = findViewById(R.id.setPlanetImage);
        TextView planetname = findViewById(R.id.setPlanetName);
        TextView planetdesc = findViewById(R.id.setPlanetDescription);

        String getPlanetName = getIntent().getStringExtra("Name");
        int getPlanetImage = getIntent().getIntExtra("Image", 0);
        String getPlanetDescription = getIntent().getStringExtra("Description");

        planetimg.setImageResource(getPlanetImage);
        planetname.setText(getPlanetName);
        planetdesc.setText(getPlanetDescription);
    }
}