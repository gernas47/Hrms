package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
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
    public Result add(JobPosition jobPosition){
        return this.jobPositionService.add(jobPosition);
    }

    @GetMapping("getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }

    @GetMapping("getByTitle")
    public DataResult<JobPosition> getByTitle(@RequestParam String title){
        return this.jobPositionService.getByTitle(title);
    }

    @GetMapping("getByTitleContains")
    public DataResult<List<JobPosition>> getByTitleContains(@RequestParam String title){
        return this.jobPositionService.getByTitleContains(title);
    }

    @GetMapping("getByTitleStartsWith")
    public DataResult<List<JobPosition>> getByTitleStartsWith(@RequestParam String title){
        return this.jobPositionService.getByTitleStartsWith(title);
    }

}
