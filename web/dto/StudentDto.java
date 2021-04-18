package pl.coderslab.schoolmenagersoft.web.dto;


import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private int pesel;
    private int age;
    private int parentMobileNumber;
    private String parentMail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate schoolStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate schoolEndDate;

    public StudentDto() {
    }

    public StudentDto(String firstName, String lastName, int pesel, int age, int parentMobileNumber, String parentMail, LocalDate schoolStartDate, LocalDate schoolEndDate) {
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

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
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
