package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.mailConfirmation.EMailConfirmation;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao){
        this.employerDao = employerDao;
    }

    @Override
    public Result add(Employer employer) {
        if (CheckIfEMailConfirmed(employer) && CheckIfEmailexists(employer) && CheckIfValidatedBySystemUser(employer)){
            this.employerDao.save(employer);
            return new SuccessResult("Kullanıcı başarılı bir şekilde eklendi");
        }
        return new ErrorResult("Kayıt oluşturulamadı");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi");
    }

    @Override
    public DataResult<Employer> getByEmaill(String email) {
        return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email), "Data bulundu");
    }

    private boolean CheckIfEMailConfirmed(Employer employer){
        EMailConfirmation emailConfirmation = new EMailConfirmation();
        if(emailConfirmation.ConfirmMail(employer)){
            return true;
        }
        return false;
    }

    private boolean CheckIfValidatedBySystemUser(Employer employer){
        return true;
    }

    private boolean CheckIfEmailexists(Employer employer){
        if(this.employerDao.getByEmail(employer.getEmail())==null){
            return true;
        }
        return false;
    }
}
