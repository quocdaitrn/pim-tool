package vn.hcmut.ap.pim.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hcmut.ap.pim.persistence.model.Project;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p ORDER BY p.projectNumber ASC")
    List<Project> findAll();

    @Query("SELECT DISTINCT p FROM Project p LEFT JOIN FETCH p.employees LEFT JOIN FETCH p.group WHERE p.id IN :ids ORDER BY p.projectNumber ASC")
    List<Project> findByIds(@Param("ids") List<Long> ids);

    Optional<Project> findByProjectNumber(int projectNumber);
}
