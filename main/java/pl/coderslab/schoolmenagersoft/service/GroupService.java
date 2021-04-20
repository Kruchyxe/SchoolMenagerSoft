package pl.coderslab.schoolmenagersoft.service;

import pl.coderslab.schoolmenagersoft.model.Employee;
import pl.coderslab.schoolmenagersoft.model.Group;
import pl.coderslab.schoolmenagersoft.web.dto.EmployeeDto;
import pl.coderslab.schoolmenagersoft.web.dto.GroupDto;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Group addGroup(GroupDto groupDto);

    List<GroupDto> findAllGroups();

    Optional<Group> getGroup(Long id);

    void deleteGroupById(Long id);

    void updateGroup(Group group);
}
