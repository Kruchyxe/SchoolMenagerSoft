package pl.coderslab.schoolmenagersoft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.coderslab.schoolmenagersoft.model.Group;
import pl.coderslab.schoolmenagersoft.repository.GroupRepository;
import pl.coderslab.schoolmenagersoft.web.dto.GroupDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Override
    public Group addGroup(GroupDto groupDto) {
        Group group = new Group(groupDto.getNumber(), groupDto.getName());
        return groupRepository.save(group);
    }

    @Override
    public List<GroupDto> findAllGroups() {
        List<Group> groups = groupRepository.findAll();
        List<GroupDto> groupDto = StreamSupport
                .stream(groups.spliterator(), false)
                .map(group -> {
                    GroupDto dto = new GroupDto();
                    BeanUtils.copyProperties(group, dto);
                    return dto;
                })
                .collect(Collectors.toList());
        return groupDto;

    }

    @Override
    public Optional<Group> getGroup(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);

    }

    @Override
    public void updateGroup(Group group) {
        groupRepository.save(group);

    }
}
