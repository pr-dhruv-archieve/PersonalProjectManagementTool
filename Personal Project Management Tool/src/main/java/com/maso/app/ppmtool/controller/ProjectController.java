package com.maso.app.ppmtool.controller;

import com.maso.app.ppmtool.model.Project;
import com.maso.app.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * For creating the project POST method is going to be used becuase here we are sending the data into the server
     *
     * ResponseEntity allows us to provide more control on the JSON object.
     * ResponseEntity is Generic type. Here we are using the Project type of ResponseEntity
     *
     * Here ResponseEntity is used because project is dealing with ReactJS so we want to control their response statuses and also JSON Object that we are going to pass to the client.
     *
     * Input parameter is Project JSON object which is going to be mapped with Project Model and stored into the database
     *
     */
    @PostMapping()
    public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
        /**
         * Returning New ResponseEntity of type Project with and we have HttpResponse status that we want to setup.
         */
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project,HttpStatus.CREATED);
    }
}
