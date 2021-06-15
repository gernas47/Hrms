package kodlamaio.hrms.core.adapters.mernisAdapter;

import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class FakeMernisManager implements UserCheckService{
    @Override
    public boolean CheckIfRealPerson(Candidate candidate) {
        return true;
    }
}
