package com.example.bbw_stage_4eme_bourawi.application;

import com.example.bbw_stage_4eme_bourawi.job.Job_entity;
import com.example.bbw_stage_4eme_bourawi.job.Jobrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class Service_App {
    @Autowired
    private Apprepository apprepository;

    @Autowired
    private Jobrepository jobrepository;
    @Transactional
    public Application_entity applyForJob(Application_entity application, long jobId) {
        Job_entity job = jobrepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        application.setJob(job);

        return apprepository.save(application);
    }
}
