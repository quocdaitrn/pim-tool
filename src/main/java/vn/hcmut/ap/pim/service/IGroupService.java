package vn.hcmut.ap.pim.service;

import vn.hcmut.ap.pim.persistence.model.Groupe;

import java.util.List;

public interface IGroupService {
    List<Groupe> findAll();

    Groupe findById(Long id);

    Groupe save(Groupe groupe);
}
