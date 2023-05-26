package com.example.ColegioSpring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Profesor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesor extends BaseClass{
    protected String nombre;
    protected String apellido;
    protected int edad;
    @OneToOne
    private Materia materia;
}
