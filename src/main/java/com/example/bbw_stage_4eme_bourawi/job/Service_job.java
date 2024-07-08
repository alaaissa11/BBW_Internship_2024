package com.example.bbw_stage_4eme_bourawi.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Service_job implements IJobService {

    @Autowired
    private Jobrepository jobRepository;
@Override
    public List<Job_entity> findAll() {
        return (List<Job_entity>) jobRepository.findAll();
    }
    @Override
    public Job_entity findById(long id) {
        return jobRepository.findById(id).orElse(null);
    }
@Override
    public Job_entity addjob(Job_entity job) {
        return jobRepository.save(job);
    }
@Override
    public void deleteById(long id) {
        jobRepository.deleteById(id);
    }


    @Override
    public Job_entity updateJob(Job_entity job){
        if (jobRepository.existsById(job.getIdJob())) {
            return jobRepository.save(job);
        } else {
            throw new RuntimeException("Job not found with id " + job.getIdJob());
        }
    }


}
