package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.mernisAdapter.MernisServiceAdapter;
import kodlamaio.hrms.core.adapters.mernisAdapter.UserCheckService;
import kodlamaio.hrms.core.mailConfirmation.EMailConfirmation;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    CandidateDao candidateDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao){
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(Candidate candidate) {
        if(CheckIfRealPerson(candidate) && CheckIfEMailConfirmed(candidate) && CheckIfEmailExists(candidate) && CheckIfIdentityNumberExists(candidate)){
            this.candidateDao.save(candidate);
            return new SuccessResult("Kullanıcı başarılı bir şekilde eklendi.");
        }
        return new ErrorResult("Kayıt gerçekleştirilemedi");
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi");
    }

    @Override
    public DataResult<Candidate> getByEmail(String email) {
        return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email), "Data bulundu");
    }

    @Override
    public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
        return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber), "Data bulundu.");
    }

    private boolean CheckIfRealPerson(Candidate candidate){
        UserCheckService checkService = new MernisServiceAdapter();
        if(checkService.CheckIfRealPerson(candidate)){
            return true;
        }
        return false;
    }

    private boolean CheckIfEMailConfirmed(Candidate candidate){
        EMailConfirmation emailConfirmation = new EMailConfirmation();
        if(emailConfirmation.ConfirmMail(candidate)){
            return true;
        }
        return false;
    }

    private boolean CheckIfEmailExists(Candidate candidate){
        if(this.candidateDao.getByEmail(candidate.getEmail()) == null){
            return true;
        }
        return false;
    }

    private boolean CheckIfIdentityNumberExists(Candidate candidate){
        if (this.candidateDao.getByIdentityNumber(candidate.getIdentityNumber()) == null){
            return true;
        }
        return false;
    }
}
