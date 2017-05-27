package com.example.jairo.serviciosweb.models;

import java.util.ArrayList;

/**
 * Created by jairo on 19/05/17.
 */


public class PokemonRespuesta
{

    //va a tener el arreglo de los pokemones
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
