package pl.coderslab.schoolmenagersoft.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    private int pesel;

    @Column(name = "mobile")
    private int mobile;

    @Column(name = "email")
    @NotBlank
    @Email
    private String email;

    @Column(name = "hire_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    @Column(name = "end_hire_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate terminationOfEmployment;

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Student> students = new ArrayList<>();


    public Employee() {
    }

    public Employee(String firstName, String lastName,
                    int pesel, int mobile, String email,
                    LocalDate hireDate, LocalDate terminationOfEmployment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.mobile = mobile;
        this.email = email;
        this.hireDate = hireDate;
        this.terminationOfEmployment = terminationOfEmployment;
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

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getTerminationOfEmployment() {
        return terminationOfEmployment;
    }

    public void setTerminationOfEmployment(LocalDate terminationOfEmployment) {
        this.terminationOfEmployment = terminationOfEmployment;
    }
}
