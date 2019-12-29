package com.maso.app.ppmtool.service;

import com.maso.app.ppmtool.exception.ProjectIDException;
import com.maso.app.ppmtool.model.Project;
import com.maso.app.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.color.ProfileDataException;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            // Here we are storing the project identifier in the Upper case so that we can remove the ambiguity in the
            // database and at the GUI as well.
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception exception) {
            throw new ProjectIDException("Project ID '" + project.getProjectIdentifier().toUpperCase()+"' already exist in the database");
        }

    }

    /**
     * To avoiding the ambiguity we are using UPPER_CASE in the ProjectID
     *
     * @param projectId
     * @return
     */
    public Project findByProjectIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null)
            throw new ProjectIDException("Project ID '" + projectId.toUpperCase()+"' doesn't exist in the database");
        return project;
    }

    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

}
