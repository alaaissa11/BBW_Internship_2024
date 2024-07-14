package com.example.bbw_stage_4eme_bourawi.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/application")
public class App_Controller {
    @Autowired
    private final Service_App serviceApp;
    @PostMapping("/apply/{jobId}")
    public ResponseEntity<Application_entity> applyForJob(
            @PathVariable long jobId,
            @RequestParam("candidateName") String candidateName,
            @RequestParam("email") String email,
            @RequestParam("cvFile") MultipartFile cvFile) {

        try {
            Application_entity application = new Application_entity();
            application.setCandidateName(candidateName);
            application.setEmail(email);
            Application_entity savedApplication = serviceApp.applyForJob(application, jobId, cvFile);
            return ResponseEntity.ok(savedApplication);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/getapp/{id}")
    public Application_entity getapp(@PathVariable("id")long idApp){
        return this.serviceApp.findById(idApp);
    }

    @PutMapping("/update")
    public Application_entity updateapp(Application_entity app){
        return this.serviceApp.updateApp(app);
    }
    @DeleteMapping("/Delete/{id}")
    public void deleteF(@PathVariable("id") long idF){
        this.serviceApp.deleteById(idF);
    }

}
