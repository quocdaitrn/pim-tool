package vn.hcmut.ap.pim.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hcmut.ap.pim.persistence.model.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.code IN :codes ORDER BY e.code ASC")
    List<Employee> findByCodes(@Param("codes") List<String> codes);

    @Query("SELECT e FROM Employee e WHERE (e.code LIKE CONCAT('%',:query,'%') OR e.firstName LIKE CONCAT('%',:query,'%')) ORDER BY e.code ASC")
    List<Employee> queryByCodeOrFirstName(@Param("query") String query);

    Optional<Employee> findByCode(String code);
}