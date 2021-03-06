package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdverts"})
public class JobPosition {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "title")
    @NotNull
    private String title;

    @OneToMany(mappedBy = "jobPositions")
    private List<JobAdvert> jobAdverts;
}
