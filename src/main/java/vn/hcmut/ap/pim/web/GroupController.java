package vn.hcmut.ap.pim.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hcmut.ap.pim.dto.GroupDto;
import vn.hcmut.ap.pim.persistence.model.Groupe;
import vn.hcmut.ap.pim.response.ResponseCode;
import vn.hcmut.ap.pim.response.ResponseMessage;
import vn.hcmut.ap.pim.service.IEmployeeService;
import vn.hcmut.ap.pim.service.IGroupService;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    List<Groupe> query() {
        return groupService.findAll();
    }

    @PostMapping
    Groupe create(@RequestBody GroupDto group) {
        Groupe groupe = new Groupe();
//        Employee e = new Employee();
//        e.setCode("NPT");
//        e.setFirstName("Phuong");
//        e.setLastName("Nha");
//        e.setBirthDate(Date.from(LocalDate.of(1994, 10, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        groupe.setGroupLeader(e);

        groupe.setGroupLeader(employeeService.findByCode(group.getGroupLeader()));

        return groupService.save(groupe);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseMessage> delete(@PathVariable("id") Long id) {
        groupService.delete(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseMessage(ResponseCode.SUCCESS, "Deleted!"));
    }
}
