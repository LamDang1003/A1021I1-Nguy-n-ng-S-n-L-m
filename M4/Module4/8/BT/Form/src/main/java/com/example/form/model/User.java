package com.example.form.model;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "may not be blank")
    @Size(min = 2, max = 45, message = "size must be between {5} and {45}")
    private String firstName;
    @NotBlank(message = "may not be blank")
    @Size(min = 2, max = 45, message = "size must be between {5} and {45}")
    private String lastName;


    @Min(value = 18, message = "must be between {18} and {200}")
    private int age;


    private int sex;


    @Size(min = 3, max = 11, message = "size must be between {10} and {11}")
    private String phoneNumber;

    @NotBlank(message = "may not be blank")
    @Email
    private String email;

    public User() {
    }

    public User(Long id, String firstName, String lastName, int sex, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", phoneNumber=" + phoneNumber +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
