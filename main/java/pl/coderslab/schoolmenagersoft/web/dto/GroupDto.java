package pl.coderslab.schoolmenagersoft.web.dto;

import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GroupDto {


    private Long id;
    @NotNull
    @Range(min = 1, max = 8)
    private int number;
    @NotBlank
    @Size(max = 1)
    private String name;

    public GroupDto() {
    }

    public GroupDto(Long id, int number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
