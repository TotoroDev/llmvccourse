package com.boot.beans;

import com.boot.validation.annotations.Age;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 1, message = "${user.empty.username}")
    private String username;
    @Pattern(regexp = "((?=.*[A-Z]).{1,10})", message = "${user.not-valid.password}")
    private String password;
    @NotEmpty(message = "${user.empty.firstname}")
    private String firstName;
    @NotEmpty(message = "${user.empty.lastname}")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull(message = "${user.empty.activity}")
    private String activity;
    @Age(age = 10)
    private Date dateOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) throws Exception {
        this.dateOfBirth = dateOfBirth;
    }
}
