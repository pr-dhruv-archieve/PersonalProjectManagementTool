package com.maso.app.ppmtool.controller;

import com.maso.app.ppmtool.model.Project;
import com.maso.app.ppmtool.service.MapValidationErrorService;
import com.maso.app.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * Step 1
     * For creating the project POST method is going to be used becuase here we are sending the data into the server
     *
     * Step 2
     * ResponseEntity allows us to provide more control on the JSON object.
     * ResponseEntity is Generic type. Here we are using the Project type of ResponseEntity
     *
     * Here ResponseEntity is used because project is dealing with ReactJS so we want to control their response statuses and also JSON Object that we are going to pass to the client.
     *
     * Input parameter is Project JSON object which is going to be mapped with Project Model and stored into the database
     *
     * Step 3
     * If the object is not valid then server is going to fire the exceptions which are very hard to understand.
     * We need to validate the RequestBody first to for validating the object the @Valid annotation is used. It gives
     * the better response if the RequestBody is not valid.
     *
     * If we are not using @Valid annotation then Error 500(Internal Server error) is going to be appeared which is not understandable
     * after using @Valid it gives Error 400(Bad Request) with details
     *
     * Step 4
     * BindingResult is an interface which invokes the validation on the object.
     * It analyzes the object and determine the object have the error or not.
     *
     * Step 5
     * Now, we are trying to customizing the error JSON message in the following format
     * {
     *     "field":"message",
     *     .
     *     .
     *     .
     *     .
     * }
     * This is going to be easier to the ReactJS to catch the JSON data to grab and display whenever the bad data is sent to the server.
     * For this we are going to useFieldError.
     *
     * BindingResult result:
     * It will contains all the errors if found. We need to extract the data which we want.
     * Here we are using result.getFieldErrors() to get all the fields error and return List<FieldError>
     * so the type of the ResponseEntity must be List<FieldError>
     *
     * Since from the result object/Bean we can receive only the field name not he default error message where the error message is displayed.
     * JSON data follows the <key, value> pair concept which is easily implemented in the Map.
     * So we will create a Map.
     *
     * Step 6
     * Remove Error logic from the controllers and put the logic in the service layer called the MapValidationErrorService
     * and call the method by autowiring the object of MapValidationErrorService.
     */
    @PostMapping()
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
        // If errors found in the error Project Objects
        ResponseEntity<?> errorMap = mapValidationErrorService.getValidationErrors(result);
        if(errorMap != null)
            return errorMap;
        // If no errors are found in the Project Object
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1,HttpStatus.CREATED);
    }
}