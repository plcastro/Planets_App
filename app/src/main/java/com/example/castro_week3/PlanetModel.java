package com.example.castro_week3;
public class PlanetModel {
    private String planet_name, planet_desc;
    private int planet_img;
    public PlanetModel(String planet_name, int planet_img, String planet_desc) {
        this.planet_name = planet_name;
        this.planet_desc = planet_desc;
        this.planet_img = planet_img;
    }
    public String getPlanet_name() {
        return planet_name;
    }

    public String getPlanet_desc() {
        return planet_desc;
    }

    public int getPlanet_img() {
        return planet_img;
    }
 }
