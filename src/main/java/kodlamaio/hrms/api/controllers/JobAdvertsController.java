package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertWithCompanyAndJobPositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobAdverts/")
public class JobAdvertsController {

    private JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService){
        this.jobAdvertService = jobAdvertService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobAdvert jobAdvert){
        return this.jobAdvertService.add(jobAdvert);
    }

    @GetMapping("getall")
    DataResult<List<JobAdvert>> getall(){
        return this.jobAdvertService.getall();
    }

    @GetMapping("getJobAdvertWithCompanyAndJobPositionDetails")
    DataResult<List<JobAdvertWithCompanyAndJobPositionDto>> getJobAdvertWithCompanyAndJobPositionDetails(){
        return this.jobAdvertService.getJobAdvertWithCompanyAndJobPositionDetails();
    }

    @GetMapping("getAllActiveJobAdvertsByDateDescending")
    DataResult<List<JobAdvertWithCompanyAndJobPositionDto>> getAllActiveJobAdvertsByDateDescending(){
        return this.jobAdvertService.getAllActiveJobAdvertsByDateDescending();
    }

    @GetMapping("getAllActiceJobAdvertsByEmployer")
    DataResult<List<JobAdvertWithCompanyAndJobPositionDto>> getAllActiceJobAdvertsByEmployer(@RequestParam int id){
        return this.jobAdvertService.getAllActiceJobAdvertsByEmployer(id);
    }

    @GetMapping("getById")
    DataResult<JobAdvert> getById(@RequestParam int id){
        return this.jobAdvertService.getById(id);
    }
}
