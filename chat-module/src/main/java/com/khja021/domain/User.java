package com.khja021.domain;

import com.khja021.domain.enumeration.UserRole;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */

@Entity
@Table(name = "users",schema = "soft_serve")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String firstname;

    @Column(name = "last_name", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String lastname;

    @Column(name = "user_gender")
    private String gender;

    @Column(name = "registration_date")
    private Date date;

    @Column(name = "phone")
    private String phone;

    @Column(name = "username")
    @NotEmpty @NotNull
    private String username;

    @Column(name = "email")
    @NotEmpty @NotNull
    private String email;

    @Column(name = "password")
    @NotEmpty @NotNull
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @NotEmpty @NotNull
    private UserRole role;


    @Column(name = "enabled")
    private boolean enabled;


    public User() {
    }

    public User(User user) {
        this.password = user.password;
        this.username = user.username;
        this.email = user.email;
        this.enabled = user.enabled;
        this.role = user.role;
    }

    public User(@NotNull @Size(min = 4, max = 50) String firstname, @NotNull @Size(min = 4, max = 50) String lastname, String gender, Date date, String phone, @NotEmpty @NotNull String username, @NotEmpty @NotNull String email, @NotEmpty @NotNull String password, String confirmPassword, @NotEmpty @NotNull UserRole role, boolean enabled) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.date = date;
        this.phone = phone;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role=" + role +
                ", enabled=" + enabled +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
