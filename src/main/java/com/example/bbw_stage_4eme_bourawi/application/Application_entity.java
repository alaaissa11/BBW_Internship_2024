package com.example.bbw_stage_4eme_bourawi.application;

import com.example.bbw_stage_4eme_bourawi.job.Job_entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Application_entity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idApp;
    String candidateName;
    String email;
    private String cvFilePath;
    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "idJob", nullable = false)
    private Job_entity job;
}
