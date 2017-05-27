package com.example.jairo.serviciosweb.pokeapi;

import com.example.jairo.serviciosweb.models.Pokemon;
import com.example.jairo.serviciosweb.models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jairo on 19/05/17.
 */

public interface PokeapiService
{
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}/")
    Call<Pokemon> obtenerDatosPokemon(@Path("id") int id);
}
