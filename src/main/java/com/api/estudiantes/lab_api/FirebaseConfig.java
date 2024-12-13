package com.api.estudiantes.lab_api;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import java.io.FileInputStream;

@Configuration
public class FirebaseConfig {
    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("api-estudiantes-b6c22-firebase-adminsdk-ss42p-7de53a67e3.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}