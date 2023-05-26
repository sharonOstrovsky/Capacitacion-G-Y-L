package org.example.Entity;

import org.springframework.stereotype.Component;

@Component
public class Tarjeta {
    private String numero;

    public Tarjeta() {
        System.out.println("Se esta ejecutando el constructor de tarjeta");
    }
/*
    public Tarjeta(String numero) {
        this.numero = numero;
    }
*/
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero='" + numero + '\'' +
                '}';
    }
}

