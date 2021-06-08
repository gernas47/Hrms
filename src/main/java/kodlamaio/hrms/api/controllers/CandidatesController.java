package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.CheckedInputStream;

@RestController
@RequestMapping("api/candidates/")
public class CandidatesController {

    CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @PostMapping("add")
    public Result add(Candidate candidate){
        return this.candidateService.add(candidate);
    }

    @GetMapping("getall")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }

    @GetMapping("getByEmail")
    DataResult<Candidate> getByEmail(@RequestParam String email){
        return this.candidateService.getByEmail(email);
    }

    @GetMapping("getByIdentityNumber")
    DataResult<Candidate> getByIdentityNumber(@RequestParam String identityNumber){
        return this.candidateService.getByIdentityNumber(identityNumber);
    }
}
