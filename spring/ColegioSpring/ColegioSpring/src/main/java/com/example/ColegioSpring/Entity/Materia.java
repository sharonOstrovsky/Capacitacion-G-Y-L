package com.example.ColegioSpring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Materia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Materia extends BaseClass{

    private String nombre;

   // @Temporal(TemporalType.TIME)
    private String hora;


}
