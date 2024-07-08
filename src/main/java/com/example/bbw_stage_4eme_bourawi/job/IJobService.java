package com.example.bbw_stage_4eme_bourawi.job;

import java.util.List;

public interface IJobService  {
     List<Job_entity> findAll();
     Job_entity findById(long id);
     Job_entity addjob(Job_entity job);
     void deleteById(long id);
    Job_entity updateJob(Job_entity job);


}
