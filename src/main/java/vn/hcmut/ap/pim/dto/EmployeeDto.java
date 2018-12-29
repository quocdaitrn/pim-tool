package vn.hcmut.ap.pim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hcmut.ap.pim.persistence.model.Project;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String code;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<Long> projects = new ArrayList<>();
}
