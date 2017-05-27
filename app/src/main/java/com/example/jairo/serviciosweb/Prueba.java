package com.example.jairo.serviciosweb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jairo.serviciosweb.models.Pokemon;
import com.example.jairo.serviciosweb.pokeapi.PokeapiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Prueba extends AppCompatActivity {

    private TextView nombreTextView,pesoTextView,alturaTextView,experienciaTextView,tipoTextView,habilidadTextView,habilidadTextView2,habilidadTextView3;
    private ImageView otroImageView;
    private static final String TAG="POKEDEX";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
        nombreTextView=(TextView)findViewById(R.id.nombreTextView);
        pesoTextView=(TextView)findViewById(R.id.pesoTextView);
        alturaTextView=(TextView)findViewById(R.id.AlturaTextView);
        experienciaTextView=(TextView)findViewById(R.id.ExperieciaTextView);
        tipoTextView=(TextView)findViewById(R.id.tipoTextView);
        habilidadTextView=(TextView)findViewById(R.id.habilidadTextView);
        habilidadTextView2=(TextView)findViewById(R.id.habilidadTextView2);
        habilidadTextView3=(TextView)findViewById(R.id.habilidadTextView3);
        otroImageView=(ImageView)findViewById(R.id.otroImageView);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory( GsonConverterFactory.create())
                .build();

        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null)
        {
            int idpoke=(int) bundle.get("idpoke");
            Glide.with(this)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + idpoke+ ".png")
                    .into(otroImageView);

            obtenerDatos(idpoke);
        }
    }

    public void acercade(View view)
    {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }

    public void salir(View v)
    {
        finish();
    }

    public static String ucFirst(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
    }

    private void obtenerDatos(int idpoke) {
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<Pokemon> pokemonRespuestaCall = service.obtenerDatosPokemon(idpoke);
        pokemonRespuestaCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if(response.isSuccessful()){
                    Pokemon pokemon = response.body();
                    nombreTextView.setText(pokemon.getName().toUpperCase());
                    pesoTextView.setText(  "Peso:                 "+(pokemon.getWeight())+" kg");
                    alturaTextView.setText("Altura:                "+(pokemon.getHeight())+" m");
                    experienciaTextView.setText("Experiencia:      "+pokemon.getBase_experience());
                    tipoTextView.setText("Tipo:                   "+ucFirst(pokemon.getTypes().get(0).getType().getName()));
                    habilidadTextView.setText("Habilidades:      "+ucFirst(pokemon.getAbilities().get(0).getAbility().getName()));
                    if(pokemon.getAbilities().size()>1)
                    {
                        habilidadTextView2.setText("                            "+ucFirst(pokemon.getAbilities().get(1).getAbility().getName()));
                        if(pokemon.getAbilities().size()==3)
                        {
                            habilidadTextView3.setText("                            "+ucFirst(pokemon.getAbilities().get(2).getAbility().getName()));
                        }
                    }
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}
