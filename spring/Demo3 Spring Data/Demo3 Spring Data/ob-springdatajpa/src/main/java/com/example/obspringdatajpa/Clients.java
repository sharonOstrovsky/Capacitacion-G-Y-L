package com.example.obspringdatajpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clients extends BaseClass{


    private String nombre;
    private String apellido;
    private String direccion;


   /* public Clients(){}
    public Clients(Long id, String nombre, String apellido, String direccion) {
       // this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }*/

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    /*public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }*/
}
