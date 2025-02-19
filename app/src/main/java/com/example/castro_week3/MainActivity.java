package com.example.castro_week3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    ArrayList<PlanetModel> planetModels = new ArrayList<>();
    int[] planetimage = {R.drawable.mercury, R.drawable.venus,R.drawable.earth, R.drawable.mars, R.drawable.jupiter,R.drawable.saturn, R.drawable.uranus, R.drawable.neptune};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview1);
        modelPlanets();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, planetModels, this);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d("MA", "Show items");
    }
    private void modelPlanets(){
        planetModels.clear(); // Prevents duplicates
        String [] planets = getResources().getStringArray(R.array.planet_names);
        String [] planet_desc = getResources().getStringArray(R.array.planet_description);

        for(int i = 0; i < planets.length; i++){
            planetModels.add(new PlanetModel(planets[i], planetimage[i], planet_desc[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Log.d("Item Clicked", "onItemClick: ");
        Toast.makeText(this, "Clicked planet " + planetModels.get(position).getPlanet_name(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("Name", planetModels.get(position).getPlanet_name());
        intent.putExtra("Image", planetModels.get(position).getPlanet_img());
        intent.putExtra("Description", planetModels.get(position).getPlanet_desc());
        startActivity(intent);
    }
}