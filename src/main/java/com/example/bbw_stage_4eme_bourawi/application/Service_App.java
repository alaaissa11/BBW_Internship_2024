package com.example.bbw_stage_4eme_bourawi.application;

import com.example.bbw_stage_4eme_bourawi.job.Job_entity;
import com.example.bbw_stage_4eme_bourawi.job.Jobrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class Service_App {
    @Autowired
    private Apprepository apprepository;

    @Autowired
    private Jobrepository jobrepository;
    @Transactional
    public Application_entity applyForJob(Application_entity application, long jobId, MultipartFile cvFile) throws IOException {
        Job_entity job = jobrepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        application.setJob(job);

        // Sauvegarder le fichier CV
        String fileName = saveCvFile(cvFile);
        application.setCvFilePath(fileName);

        return apprepository.save(application);
    }
    private String saveCvFile(MultipartFile cvFile) throws IOException {
        String uploadDir = "uploads/";
        String fileName = UUID.randomUUID().toString() + "_" + cvFile.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, cvFile.getBytes());
        return filePath.toString();
    }
    @Transactional
    public Application_entity findById(long id) {
        return apprepository.findById(id).orElse(null);
    }
    @Transactional
    public void deleteById(long id) {
        apprepository.deleteById(id);
    }

    public Application_entity updateApp(Application_entity app){
        if (apprepository.existsById(app.getIdApp())) {
            return apprepository.save(app);
        } else {
            throw new RuntimeException("Job not found with id " + app.getIdApp());
        }
    }
    
}
