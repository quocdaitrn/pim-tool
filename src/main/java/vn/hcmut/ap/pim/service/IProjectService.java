package vn.hcmut.ap.pim.service;

import vn.hcmut.ap.pim.dto.ProjectDto;
import vn.hcmut.ap.pim.persistence.model.Project;

import java.text.ParseException;
import java.util.List;

public interface IProjectService {
    List<Project> findAll();

    Project findById(Long id);

    Project findByProjectNumber(int projectNumber);

    void updateProject(ProjectDto projectDto) throws ParseException;

    void createProject(ProjectDto projectDto) throws ParseException;

    void deleteById(Long id);
}
