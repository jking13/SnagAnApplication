package com.jking.snag.application;

import com.jking.snag.application.entity.Application;
import com.jking.snag.exception.NoApplicationException;
import com.jking.snag.repository.ApplicationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Created by john on 3/23/17.
 */
@Component
public class ApplicationServiceBean implements ApplicationService {

    @Autowired
    private ApplicationRespository applicationRespository;

    @Override
    public Application createApplication(Application application) {
        return applicationRespository.save(application);
    }

    @Override
    public Application updateApplication(Application application) {
        if(!applicationRespository.exists(application.getId())){
            throw new NoApplicationException();
        }
        return applicationRespository.save(application);
    }

    @Override
    public Application getApplication(String id) {
        Application app =  applicationRespository.findOne(id);
        if(app == null){
            throw new NoApplicationException();
        }
        return app;
    }

    @Override
    public Page<Application> getApplications(Pageable page) {
        return applicationRespository.findAll(page);
    }

    @Override
    public void deleteApplication(String id) {
        applicationRespository.delete(id);
    }
}
