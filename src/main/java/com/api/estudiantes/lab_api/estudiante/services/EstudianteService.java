package com.api.estudiantes.lab_api.estudiante.services;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.api.estudiantes.lab_api.estudiante.models.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class EstudianteService {

    private static final String COLLECTION_NAME = "estudiantes";

    public String guardarEstudiante(Estudiante estudiante) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(estudiante.getId()).set(estudiante);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public Estudiante obtenerEstudiante(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {
            return document.toObject(Estudiante.class);
        }
        return null;
    }




    public String eliminarEstudiante(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COLLECTION_NAME).document(id).delete();
        return "Estudiante con ID " + id + " eliminado";
    }

    public List<QueryDocumentSnapshot> obtenerTodos() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_NAME).get();
        return future.get().getDocuments();
    }
}
