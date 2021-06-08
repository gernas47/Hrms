package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "verification_codes")
public class VerificationCode {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "is_verified")
    private boolean isVerified;

    @Column(name = "verifying_date")
    private LocalDate verifyingDate;
}
