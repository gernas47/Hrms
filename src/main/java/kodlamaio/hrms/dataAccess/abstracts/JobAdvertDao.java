package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertWithCompanyAndJobPositionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

    JobAdvert getById(int id);

    @Query("select new kodlamaio.hrms.entities.dtos.JobAdvertWithCompanyAndJobPositionDto(ja.id, e.companyName, jp.title, ja.quota, ja.releaseDate, ja.expirationDate) From Employer e Inner join e.jobAdverts ja Inner join ja.jobPositions jp where ja.activationStatus = true")
    List<JobAdvertWithCompanyAndJobPositionDto> getJobAdvertWithCompanyAndJobPositionDetails();

    @Query("select new kodlamaio.hrms.entities.dtos.JobAdvertWithCompanyAndJobPositionDto(ja.id, e.companyName, jp.title, ja.quota, ja.releaseDate, ja.expirationDate) From Employer e Inner join e.jobAdverts ja Inner join ja.jobPositions jp where ja.activationStatus = true Order By ja.releaseDate Desc")
    List<JobAdvertWithCompanyAndJobPositionDto> getAllActiveJobAdvertsByDateDescending();

    @Query("select new kodlamaio.hrms.entities.dtos.JobAdvertWithCompanyAndJobPositionDto(ja.id, e.companyName, jp.title, ja.quota, ja.releaseDate, ja.expirationDate) From Employer e Inner join e.jobAdverts ja Inner join ja.jobPositions jp where ja.activationStatus = true and e.id =:id")
    List<JobAdvertWithCompanyAndJobPositionDto> getAllActiceJobAdvertsByEmployer(int id);
}
