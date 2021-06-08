package kodlamaio.hrms.core.adapters.mernisAdapter;

import kodlamaio.hrms.core.mernisService.KPSPublicSoap;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements UserCheckService{

    KPSPublicSoap client = new KPSPublicSoap();

    @Override
    public boolean CheckIfRealPerson(Candidate candidate) {

        try {
            return this.client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(), candidate.getDateOfBirth().getYear());
        } catch (Exception e) {
            return false;
        }

    }
}
