package pl.coderslab.schoolmenagersoft.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.schoolmenagersoft.model.Group;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.repository.GroupRepository;
import pl.coderslab.schoolmenagersoft.web.dto.GroupDto;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GroupServiceImplTest {

    @Mock
    private GroupRepository groupRepository;

    private GroupServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new GroupServiceImpl(groupRepository);
    }

    @Test
    void addGroup() {

        // given
        GroupDto group = new GroupDto( 2,"A");

        // when
        underTest.addGroup(group);

        // then
        assertNotNull(group);
    }

    @Test
    void findAllGroups() {
        // when
        List<GroupDto> studentList = underTest.findAllGroups();
        GroupDto groupDto = new GroupDto();
        studentList.add(groupDto);
        studentList.add(groupDto);
        studentList.add(groupDto);

        // then
        verify(groupRepository).findAll();

        assertEquals(3,studentList.size());
    }

    @Test
    void getGroup() {
        when(underTest.getGroup(anyLong())).thenReturn(Optional.of(new Group()));

        Optional<Group> group = underTest.getGroup(2L);

        assertNotNull(group);
    }

    @Test
    void deleteGroupById() {

        // when
        underTest.deleteGroupById(anyLong());

        // then
        verify(groupRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void updateGroup() {
        // given
        Group group = new Group();
        group.setNumber(2);
        group.setName("B");

        // when
        underTest.updateGroup(group);

        // then
        assertThat(group.getNumber()).isEqualTo(2);
    }
}