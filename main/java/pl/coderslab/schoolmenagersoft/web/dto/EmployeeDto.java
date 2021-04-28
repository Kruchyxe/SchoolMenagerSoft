package pl.coderslab.schoolmenagersoft.web.dto;

import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EmployeeDto {


    private Long id;

    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    @PESEL
    private String pesel;

    private int mobile;

    @NotBlank
    @Email(message = "{email.not.valid}")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate terminationOfEmployment;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String firstName,
                       String lastName,
                       String pesel, int mobile,
                       String email,
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
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
