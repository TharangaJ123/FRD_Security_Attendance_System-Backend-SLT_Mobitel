package com.frdAttendance.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "system_user")
public class SystemUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId; // Unique identifier for the user

    @Column(name = "user_role")
    private String userRole; // The role of the user

    @OneToMany(mappedBy = "systemUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InternalUsers> internalUsers;

    public int getEmpId() {
        return empId;
    }

    public String getUserRole() {
        return userRole;
    }

}