package vn.hcmut.ap.pim.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hcmut.ap.pim.dto.GroupDto;
import vn.hcmut.ap.pim.persistence.model.Groupe;
import vn.hcmut.ap.pim.service.IEmployeeService;
import vn.hcmut.ap.pim.service.IGroupService;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/groups")
    List<Groupe> query() {
        return groupService.findAll();
    }

    @PostMapping("/groups")
    Groupe create(@RequestBody GroupDto group) {
        Groupe groupe = new Groupe();
        groupe.setGroupLeader(employeeService.findByCode(group.getGroupLeader()));

        return groupService.save(groupe);
    }
}
