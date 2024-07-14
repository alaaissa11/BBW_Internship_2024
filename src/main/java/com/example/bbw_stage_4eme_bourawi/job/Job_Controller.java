package com.example.bbw_stage_4eme_bourawi.job;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/job")
@RestController
public class Job_Controller {
    private final IJobService jobService ;

    @GetMapping("/getalljobs")
    public List<Job_entity> getAll(){
        return jobService.findAll();
    }

    @PostMapping("/addjob")
    public Job_entity addjob (@RequestBody Job_entity j){
        return this.jobService.addjob(j);
    }

    @PutMapping("/update")
    public Job_entity updatejob(Job_entity j){
        return this.jobService.updateJob(j);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteF(@PathVariable("id") long idF){
        this.jobService.deleteById(idF);
    }

    @GetMapping("/getjob/{id}")
    public Job_entity getjob(@PathVariable("id")long idFoyer){
        return this.jobService.findById(idFoyer);
    }


}
