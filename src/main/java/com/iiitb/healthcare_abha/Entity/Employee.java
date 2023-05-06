package com.iiitb.healthcare_abha.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="employee")
public class Employee implements UserDetails {

    @Column(name = "employee_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    long employee_id;




//    @OneToOne (mappedBy="employee")
//    private Admin admin;
//    @OneToOne (mappedBy="employee")
//    private FrontDesk frontDesk;
//    @OneToOne (mappedBy="employee")
//    private Doctor doctor;


    @Column(name = "employee_name")
    String employee_name;
    @Column(name = "mobile_number",nullable = false)
    long mobile_number;

    @Column(name = "email")
    String email;


    @Column(name = "password",nullable = false)
    String password;

    @Column(name="address")
    String address;

    @Column(name="employee_type")
    String employee_type;

    @Column(name="blood_group")
    String blood_group;

    /*@Column(name="age")
    int age;*/

    @Column(name="gender")
    String gender;

   @Column(name = "date_of_birth")
    //@Temporal(TemporalType.TIMESTAMP)
    private String date_of_birth;

    @Column(name = "joining_date")
    //@Temporal(TemporalType.TIMESTAMP)
    private String joining_date;


    @Column(name="department")
    private String department;

    @Column(name="image")
    private String image;


    @Column(name="abha_Id")
    private String abha_Id;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roles= new ArrayList<>();
        roles.add(this.getEmployee_type());

        System.out.println(roles);


        List<SimpleGrantedAuthority> simpleGrantedAuthorityList=roles.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());

        System.out.println(simpleGrantedAuthorityList);
        return simpleGrantedAuthorityList;
    }


    @Override
    public String getUsername() {
        return this.email;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
