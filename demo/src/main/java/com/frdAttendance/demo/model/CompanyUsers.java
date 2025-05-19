package com.frdAttendance.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company_user")
public class CompanyUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "representativeName", nullable = false)
    private String name;

    @Column(name = "designataion", nullable = false)
    private String designation;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "contactNumber", nullable = false, unique = true)
    private String contactNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    private SecurityCompany company; // Removed CascadeType.ALL

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public SecurityCompany getCompany() {
        return company;
    }
}