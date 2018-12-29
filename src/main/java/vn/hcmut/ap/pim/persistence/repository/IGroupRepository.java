package vn.hcmut.ap.pim.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hcmut.ap.pim.persistence.model.Groupe;

@Repository
public interface IGroupRepository extends JpaRepository<Groupe, Long> {
}
