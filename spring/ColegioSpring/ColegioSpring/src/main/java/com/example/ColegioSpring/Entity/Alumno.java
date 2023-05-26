package com.example.ColegioSpring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Alumno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno extends BaseClass{

    protected String nombre;
    protected String apellido;
    protected int edad;
    @ManyToMany
    private List<Materia> materias;

}
