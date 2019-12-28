package com.maso.app.ppmtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the second component which we are making the exception package.
 *
 * Since we want to return the HttpResponse code as well so we are annotating it with @ResponseStatus for BAD_REQUEST
 *
 * This exception is made for the ProjectID unique validation, because @Column annotation define the validation which
 * will be done at the table level or DAO layer, so the database is going to fire the exception.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIDException extends RuntimeException {
    public ProjectIDException(String message) {
        super(message);
    }
}
