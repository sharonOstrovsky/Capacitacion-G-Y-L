package org.example.Entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Banco {
    private ArrayList<CuentaBancaria> cuentas;

   // public Banco() {}

    public Banco(ArrayList<CuentaBancaria> cuentas) {
        System.out.println("Se esta ejecutando el constructor de banco");
        this.cuentas = cuentas;
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "cuentas=" + cuentas +
                '}';
    }
}
