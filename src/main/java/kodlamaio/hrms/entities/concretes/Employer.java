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
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdverts"})
public class Employer extends User{
    @Id
    @Column(name = "user_id")
    @NotNull
    private int id;

    @Column(name = "company_name")
    @NotNull
    private String companyName;

    @Column(name = "web_address")
    @NotNull
    private String webAddress;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvert> jobAdverts;
}
