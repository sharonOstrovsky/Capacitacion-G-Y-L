package org.example.Service;


import org.example.Entity.Tarjeta;
import org.example.Utility.Comparators;
import org.springframework.stereotype.Component;

import java.util.TreeSet;

@Component
public class TarjetaService {

    TreeSet<String> tarjetas = new TreeSet<>(Comparators.comparaNumero);



    public Tarjeta crearTarjeta(Tarjeta tarjeta){
        //Tarjeta tarjeta = new Tarjeta();
        String numTarjeta = "";

        numTarjeta = crearNumeroTarjeta();

        if(validarNumeroTarjeta(numTarjeta, tarjeta)){
            return tarjeta;

        }else{
            return crearTarjeta(tarjeta);
        }
    }

    private String crearNumeroTarjeta(){
        String numeroTarjeta = "";

        for (int i = 0; i < 16; i++) {//16

            numeroTarjeta += Integer.toString(Aleatorio(0,9));

        }
        return numeroTarjeta;
    }

    private boolean validarNumeroTarjeta(String numTarjeta, Tarjeta tarjeta){
         int cantTarjetas = tarjetas.size();

         tarjetas.add(numTarjeta);

         if(cantTarjetas != tarjetas.size()){
             tarjeta.setNumero(numTarjeta);
             return true;
         }else{
             return false;

         }

    }



    public static int Aleatorio(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }



}
