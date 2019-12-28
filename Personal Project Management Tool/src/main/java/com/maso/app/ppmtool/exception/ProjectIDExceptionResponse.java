package com.maso.app.ppmtool.exception;

/**
 * This is the first component which we are going to make in the exeption package
 *
 * This is the first component for the exception which handles the structure of the exception message
 * This is the structure we are trying accomplish
 */
public class ProjectIDExceptionResponse {
    /**
     * This variable is used to handle the message which we want to display with "projectIdentifier key in the JSON data
     */
    private String projectIdentifier;

    public ProjectIDExceptionResponse() {
        super();
    }

    public ProjectIDExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
