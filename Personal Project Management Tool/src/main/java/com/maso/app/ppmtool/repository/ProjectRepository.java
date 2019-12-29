package com.maso.app.ppmtool.repository;

import com.maso.app.ppmtool.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    /**
     * This function basically find the project based on some projectId
     * @param projectId
     * @return
     */
    Project findByProjectIdentifier(String projectId);

    /**
     * This is method is used to find all the project in the database.
     * We want to perform some changes in the method that is why we are overriding the method
     * @return
     */
    @Override
    Iterable<Project> findAll();
}
