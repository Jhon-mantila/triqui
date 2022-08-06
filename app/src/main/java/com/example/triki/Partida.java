package com.example.triki;

import java.util.Random;

public class Partida {

    public Partida(int dificultad){

        this.dificultad = dificultad;

        jugador = 1;

        //Relleno el array en ceros
        casillas_ocupadas = new int[9];

        for (int i = 0 ; i < 9; i++){

            casillas_ocupadas[i]=0;
        }

       for(int j=0; j<casillas_ocupadas.length; j++){
           System.out.println("posición: " + j + " valor: " +casillas_ocupadas[j]);
       }

    }

    public boolean comprueba_casilla_ocupada(int casilla){

        if(casillas_ocupadas[casilla] != 0){
            return false;
        }else{
            casillas_ocupadas[casilla] = jugador;
        }

        for(int j=0; j<casillas_ocupadas.length; j++){
            System.out.println("posición: " + j + " valor: " +casillas_ocupadas[j]);
        }

        return true;
    }

    //para los turnos
    public void turno(){

        for(int i=0; i<COMBINACIONES.length; i++) {

            for(int pos: COMBINACIONES[i]) {

                System.out.println("Valor en posición: " + i + " " + casillas_ocupadas[pos]);
            }
        }

        jugador++;

        if(jugador>2){

            jugador = 1;

        }
    }
    //inteligencia artificial
    public int ia(){

        int casilla;

        Random casilla_azar = new Random();

        casilla = casilla_azar.nextInt(9);

        //regreso el numero aleatorio de 0 a 8
        return casilla;

    }
    public int jugador;

    public final int dificultad;

    private int casillas_ocupadas[];

    private final int [][] COMBINACIONES = {
            {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}
    };
}
