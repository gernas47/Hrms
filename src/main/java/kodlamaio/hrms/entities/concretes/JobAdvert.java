package kodlamaio.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_adverts")
public class JobAdvert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    @NotNull
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPositions;

    @NotNull
    @ManyToMany()
    @JoinColumn(name = "city_id")
    private List<City> cities;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "quota")
    @NotNull
    private int quota;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "activation_status")
    private boolean activationStatus;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
