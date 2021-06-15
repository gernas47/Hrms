package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertWithCompanyAndJobPositionDto;

import java.util.List;

public interface JobAdvertService {
    Result add(JobAdvert jobAdvert);
    DataResult<List<JobAdvert>> getall();
    DataResult<JobAdvert> getById(int id);
    DataResult<List<JobAdvertWithCompanyAndJobPositionDto>> getJobAdvertWithCompanyAndJobPositionDetails();
    DataResult<List<JobAdvertWithCompanyAndJobPositionDto>> getAllActiveJobAdvertsByDateDescending();
    DataResult<List<JobAdvertWithCompanyAndJobPositionDto>> getAllActiceJobAdvertsByEmployer(int id);
}
