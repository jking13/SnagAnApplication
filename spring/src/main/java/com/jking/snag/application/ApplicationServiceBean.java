package com.jking.snag.application;

import com.jking.snag.application.entity.Application;
import com.jking.snag.exception.NoApplicationException;
import com.jking.snag.repository.elasticsearch.ApplicationRespository;
import com.jking.snag.validation.ApplicationValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Created by john on 3/23/17.
 */
@Component
public class ApplicationServiceBean implements ApplicationService {


    private final ApplicationRespository applicationRespository;
    private final ApplicationValidator applicationValidator;

    @Autowired
    public ApplicationServiceBean(ApplicationRespository applicationRespository,
                                  ApplicationValidator applicationValidator) {
        this.applicationRespository = applicationRespository;
        this.applicationValidator = applicationValidator;
    }

    @Override
    public Application createApplication(Application application) {
        if(applicationValidator.validate(application)){
            return applicationRespository.save(application);
        }
        return application;
    }

    @Override
    public Application updateApplication(Application application) {
        if(!applicationRespository.exists(application.getId())){
            throw new NoApplicationException();
        }
        if(applicationValidator.validate(application)){
            return applicationRespository.save(application);
        }
        return application;
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
    public Page<Application> getApplications(Pageable page, String query) {
        return StringUtils.isBlank(query)?
                applicationRespository.findAll(page):
                applicationRespository.query(query, page);
    }

    @Override
    public void deleteApplication(String id) {
        applicationRespository.delete(id);
    }
}
