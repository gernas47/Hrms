package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employers/")
public class EmployersController {

    EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService){
        this.employerService = employerService;
    }

    @PostMapping("add")
    public Result add(Employer employer){
        return this.employerService.add(employer);
    }

    @GetMapping("getall")
    public DataResult<List<Employer>> getall(){
        return this.employerService.getAll();
    }

    @GetMapping("getByEmaill")
    DataResult<Employer> getByEmaill(@RequestParam String email){
        return this.employerService.getByEmaill(email);
    }
}
