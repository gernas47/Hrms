package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertWithCompanyAndJobPositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao){
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public Result add(JobAdvert jobAdvert) {
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("İş ilanı eklendi");
    }

    @Override
    public DataResult<List<JobAdvert>> getall() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(), "Data liselendi");
    }

    @Override
    public DataResult<JobAdvert> getById(int id) {
        return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(id), "Data bulundu");
    }

    @Override
    public DataResult<List<JobAdvertWithCompanyAndJobPositionDto>> getJobAdvertWithCompanyAndJobPositionDetails() {
        return new SuccessDataResult<List<JobAdvertWithCompanyAndJobPositionDto>>(this.jobAdvertDao.getJobAdvertWithCompanyAndJobPositionDetails(), "Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertWithCompanyAndJobPositionDto>> getAllActiveJobAdvertsByDateDescending() {
        return new SuccessDataResult<List<JobAdvertWithCompanyAndJobPositionDto>>(this.jobAdvertDao.getAllActiveJobAdvertsByDateDescending(), "Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertWithCompanyAndJobPositionDto>> getAllActiceJobAdvertsByEmployer(int id) {
        return new SuccessDataResult<List<JobAdvertWithCompanyAndJobPositionDto>>(this.jobAdvertDao.getAllActiceJobAdvertsByEmployer(id), "Data listelendi");
    }
}
