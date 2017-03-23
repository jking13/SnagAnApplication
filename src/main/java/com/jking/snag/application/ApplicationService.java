package com.jking.snag.application;

import com.jking.snag.application.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by john on 3/23/17.
 */
public interface ApplicationService {

    public Application createApplication(Application application);
    public Application updateApplication(Application application);
    public Application getApplication(String id);
    public Page<Application> getApplications(Pageable page);
    public void deleteApplication(String id);
}
