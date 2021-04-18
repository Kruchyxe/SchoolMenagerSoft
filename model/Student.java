package pl.coderslab.schoolmenagersoft.model;

import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @Size(min = 2, max = 25)
    private String firstName;
    @Column(name = "last_name")
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
    @NotNull
    @PESEL
    private int pesel;
    @NotNull
    @Digits(integer = 2, fraction = 0)
    private int age;
    @Column(name = "parent_mobile")
    private int parentMobileNumber;
    @Column(name = "parent_email")
    @Email
    private String parentMail;
    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate schoolStartDate;
    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate schoolEndDate;


    public Student() {
    }

    public Student(String firstName, String lastName, int pesel, int age, int parentMobileNumber, String parentMail, LocalDate schoolStartDate, LocalDate schoolEndDate) {
        this.id = id;
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
