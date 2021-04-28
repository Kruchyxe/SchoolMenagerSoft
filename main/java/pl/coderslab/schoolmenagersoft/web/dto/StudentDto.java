package pl.coderslab.schoolmenagersoft.web.dto;


import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;


public class StudentDto {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    @PESEL
    private String pesel;

    @NotNull
    @Digits(integer = 2, fraction = 0)
    private int age;

    private int parentMobileNumber;

    @Email(message = "{email.not.valid}")
    private String parentMail;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate schoolStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate schoolEndDate;

    public StudentDto() {
    }

    public StudentDto(String firstName, String lastName, String pesel, int age, int parentMobileNumber, String parentMail, LocalDate schoolStartDate, LocalDate schoolEndDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.age = age;
        this.parentMobileNumber = parentMobileNumber;
        this.parentMail = parentMail;
        this.schoolStartDate = schoolStartDate;
        this.schoolEndDate = schoolEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getParentMobileNumber() {
        return parentMobileNumber;
    }

    public void setParentMobileNumber(int parentMobileNumber) {
        this.parentMobileNumber = parentMobileNumber;
    }

    public String getParentMail() {
        return parentMail;
    }

    public void setParentMail(String parentMail) {
        this.parentMail = parentMail;
    }

    public LocalDate getSchoolStartDate() {
        return schoolStartDate;
    }

    public void setSchoolStartDate(LocalDate schoolStartDate) {
        this.schoolStartDate = schoolStartDate;
    }

    public LocalDate getSchoolEndDate() {
        return schoolEndDate;
    }

    public void setSchoolEndDate(LocalDate schoolEndDate) {
        this.schoolEndDate = schoolEndDate;
    }
}
