package com.example.triki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciamos el array casillas, que identifica las casillas del juego.

        casillas = new int[9];
        //inicializo el array con las posiciones de las imagenes
        casillas[0] = R.id.a1;
        casillas[1] = R.id.a2;
        casillas[2] = R.id.a3;
        casillas[3] = R.id.b1;
        casillas[4] = R.id.b2;
        casillas[5] = R.id.b3;
        casillas[6] = R.id.c1;
        casillas[7] = R.id.c2;
        casillas[8] = R.id.c3;
    }

    public void jugar(View vista){

        ImageView imagen;

        for(int cadaCasilla: casillas){
            //recorro cada posicion de las imagenees
            imagen = (ImageView) findViewById(cadaCasilla);
            //busco el recurso de la imagen con el siguiente metodo
            imagen.setImageResource(R.drawable.casilla);
        }

        jugadores = 1;

        //Solo capturo el segundo botón(vista)
        if(vista.getId()==R.id.dos_jug){

            jugadores = 2;
        }

        RadioGroup configDificultad = (RadioGroup) findViewById(R.id.configGrupo);

        int id_boton_radio = configDificultad.getCheckedRadioButtonId();

        int dificultad = 0;

        if(id_boton_radio == R.id.normal){

            dificultad = 1;

        }else if( id_boton_radio == R.id.imposible){

            dificultad = 2;
        }

        partida = new Partida(dificultad);

        findViewById(R.id.un_jug).setEnabled(false);

        findViewById(R.id.configGrupo).setAlpha(0);

        findViewById(R.id.dos_jug).setEnabled(false);


    }

    public void toque(View vista){

        if (partida == null){

            return;

        }
            int casilla = 0;

            System.out.println("Casilla tocada:"+ vista.getId());
            System.out.println("Array Casilla 0:" + casillas[0]);

            for(int i = 0; i < 9; i++){

                if(casillas[i] == vista.getId()){

                    casilla = i;
                    System.out.println("casilla valor i:"+ casilla);
                    break;
                }
            }

            marca(casilla);

            Toast toast = Toast.makeText(this, "casilla: " + casilla, Toast.LENGTH_LONG);

            toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);

            toast.show();

    }

    private void marca(int casilla){

        ImageView imagen;

        imagen = (ImageView) findViewById(casillas[casilla]);

        if(partida.jugador == 1){
            //asignar imagen
            imagen.setImageResource(R.drawable.circulo);
        }else {
            imagen.setImageResource(R.drawable.equis);
        }
    }

    private int jugadores;

    private int[] casillas;

    private Partida partida;


}