package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao){
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if(CheckIfJobPositionExists(jobPosition)){
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult("Pozisyon eklendi");
        }
        return new ErrorResult("Girdiğiniz iş pozisyonu zaten var");
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Data Listelendi");
    }

    @Override
    public DataResult<JobPosition> getByTitle(String title) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.getByTitle(title), "Data listelendi");
    }

    @Override
    public DataResult<List<JobPosition>> getByTitleContains(String title) {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByTitleContains(title), "Data listelendi");
    }

    @Override
    public DataResult<List<JobPosition>> getByTitleStartsWith(String title) {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByTitleStartsWith(title), "Data listelendi");
    }


    private boolean CheckIfJobPositionExists(JobPosition jobPosition){
        if (jobPositionDao.getByTitle(jobPosition.getTitle())==null){
            return true;
        }
        return false;
    }
}
