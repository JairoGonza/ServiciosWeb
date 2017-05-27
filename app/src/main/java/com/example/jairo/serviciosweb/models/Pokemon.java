package com.example.jairo.serviciosweb.models;

import java.util.ArrayList;

/**
 * Created by jairo on 19/05/17.
 */

public class Pokemon
{
    //creo los atributos name y url y doy click derecho en generar get and set y selecciono los atributos
    private String name;
    private String url;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }


    private double weight;
    private double height;
    private String  base_experience;
    private ArrayList<Types> types;
    private ArrayList<Abilities> abilities;

    public double getWeight() {
        return weight/10;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height/10;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public ArrayList<Types> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Types> types) {
        this.types = types;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public ArrayList<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Abilities> abilities) {
        this.abilities = abilities;
    }

}
