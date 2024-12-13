package com.api.estudiantes.lab_api.estudiante.controllers;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.api.estudiantes.lab_api.estudiante.models.Estudiante;
import com.api.estudiantes.lab_api.estudiante.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public String guardarEstudiante(@RequestBody Estudiante estudiante) throws ExecutionException, InterruptedException {
        return estudianteService.guardarEstudiante(estudiante);
    }

    @GetMapping("/{id}")
    public Estudiante obtenerEstudiante(@PathVariable String id) throws ExecutionException, InterruptedException {
        return estudianteService.obtenerEstudiante(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarEstudiante(@PathVariable String id) {
        return estudianteService.eliminarEstudiante(id);
    }

    @GetMapping
    public List<Estudiante> obtenerTodos() throws ExecutionException, InterruptedException {
        // Obtenemos los documentos de Firebase como QueryDocumentSnapshot
        List<QueryDocumentSnapshot> documents = estudianteService.obtenerTodos();

        // Convertimos cada documento en un objeto Estudiante
        List<Estudiante> estudiantes = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            estudiantes.add(document.toObject(Estudiante.class));
        }

        return estudiantes; // Retornamos solo los datos necesarios
    }
}