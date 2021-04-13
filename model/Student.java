package pl.coderslab.schoolmenagersoft.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private int pesel;

    private int age;
    @Column(name = "parent_mobile")
    private int parentMobileNumber;
    @Column(name = "parent_email")
    private String parentMail;
    @Column(name = "start_date")
    private LocalDate schoolStartDate;
    @Column(name = "end_date")
    private LocalDate schoolEndDate;


    public Student() {
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
