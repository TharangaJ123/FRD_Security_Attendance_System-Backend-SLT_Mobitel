package com.frdAttendance.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="internal_users")
public class InternalUsers {

    @Id
    @Column(name="user_id", nullable = false)
    private String userId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="contact", nullable = false)
    private String contact;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name="emp_id", nullable = false)
    private SystemUsers systemUser; // Reference to a single SystemUser

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public SystemUsers getSystemUser() {
        return systemUser;
    }

    public int getEmpId() {
        if (systemUser != null) {
            System.out.println("Emp ID: " + systemUser.getEmpId());
            return systemUser.getEmpId();
        }
        return -99;
    }

}