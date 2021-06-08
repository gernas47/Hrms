package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    Result add(JobPosition jobPosition);
    DataResult<List<JobPosition>> getAll();
    DataResult<JobPosition> getByTitle(String title);
    DataResult<List<JobPosition>> getByTitleContains(String title);
    DataResult<List<JobPosition>> getByTitleStartsWith(String title);
}
