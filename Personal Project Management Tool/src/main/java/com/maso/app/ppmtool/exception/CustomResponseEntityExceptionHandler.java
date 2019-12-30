package com.maso.app.ppmtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Mahendra Prajapati
 *
 * It is a classes which we are using to create the custom exception in the boot for the project.
 *
 * Here we are using @ControllerAdvice annotation.
 * This annotation is a mechanism to break a way from having exception handlers that are controller specific.
 * This basically helps you to match all exception declared with the Exception Handler and gives you global
 * exception handling for the controllers.
 *
 * So all the exception that we are wiring(using) here, so the controller is throwing that exception it going to come
 * here for advise and handle to exception properly.
 *
 * Another annotation is @RestController, this is controller for handling the exception so it is declared as
 * RestController and it is going to be child class of ResponseEntityExceptionHandler
 *
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * This method is going to use for handling the exception. This is two Parameter
     * @param projectIDException
     * @param webRequest
     * @return
     *
     * First parameter is the exception itself and the second parameter is WebRequest.
     *
     * We are trying to achieve the following JSON format
     * {
     *     "projectIdentifier": "Project ID '<Project ID>' already exist in the database"
     * }
     *
     */

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIDException(ProjectIDException projectIDException, WebRequest webRequest) {
        /**
         * Setting up response with the message of the exception so parameter is the message that we are passing to ProjectIDExceptionResponse
          */

        ProjectIDExceptionResponse projectIDExceptionResponse = new ProjectIDExceptionResponse(projectIDException.getMessage());

        // Now we are sending the response with HttpResponse status
        return new ResponseEntity(projectIDExceptionResponse, HttpStatus.BAD_REQUEST);

        // Now we need to catch this where the exception is been caught that is ProjectService Class in saveOrUpdateProject()
    }
}
