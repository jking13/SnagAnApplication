package com.jking.snag.controller;

import com.jking.snag.application.ApplicationService;
import com.jking.snag.application.entity.Application;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author john.king
 */
@Controller
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        return new ResponseEntity<>( applicationService.createApplication(application), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
        return new ResponseEntity<>( applicationService.updateApplication(application), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{applicationId}")
    public ResponseEntity<Application> getApplication(@PathVariable String applicationId) {
        return new ResponseEntity<>( applicationService.getApplication(applicationId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public ResponseEntity<PageWrapper> getApplications(@RequestBody RestPage page) {
        return new ResponseEntity<>( new PageWrapper(applicationService.getApplications(page.toPage())), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value  = "/{applicationId}")
    public ResponseEntity deleteApplication(@PathVariable String applicationId) {
        applicationService.deleteApplication(applicationId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
