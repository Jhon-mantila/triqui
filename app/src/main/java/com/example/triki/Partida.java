package com.example.triki;

import java.util.Random;

public class Partida {

    public Partida(int dificultad){

        this.dificultad = dificultad;

        jugador = 1;

    }

    //para los turnos
    public void turno(){

        jugador++;

        if(jugador>2){

            jugador = 1;

        }
    }

    public int ia(){

        int casilla;

        Random casilla_azar = new Random();

        casilla = casilla_azar.nextInt(9);

        //regreso el numero aleatorio de 0 a 8
        return casilla;

    }
    public int jugador;

    public final int dificultad;
}
