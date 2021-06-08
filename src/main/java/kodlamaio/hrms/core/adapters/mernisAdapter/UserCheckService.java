package kodlamaio.hrms.core.adapters.mernisAdapter;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface UserCheckService {
    boolean CheckIfRealPerson(Candidate candidate);
}
