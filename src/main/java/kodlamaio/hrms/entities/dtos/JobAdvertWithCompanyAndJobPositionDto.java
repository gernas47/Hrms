package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertWithCompanyAndJobPositionDto {
    private int id;
    private String companyName;
    private String jobPositionName;
    private int quota;
    private LocalDate releaseDate;
    private LocalDate expirationDate;
}
