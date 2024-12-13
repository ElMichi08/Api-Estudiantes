package com.api.estudiantes.lab_api.estudiante.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    private String id;
    private String nombres;
    private String apellidos;
    private int edad;
    private String nrc;
    private double promedio;
}