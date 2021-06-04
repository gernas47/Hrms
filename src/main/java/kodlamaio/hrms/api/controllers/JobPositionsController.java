package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobPositions/")
public class JobPositionsController {
    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService){
        this.jobPositionService = jobPositionService;
    }

    @PostMapping("add")
    public void add(JobPosition jobPosition){
        this.jobPositionService.add(jobPosition);
    }

    @GetMapping("getall")
    public List<JobPosition> getAll(){
        return this.jobPositionService.getAll();
    }
}
