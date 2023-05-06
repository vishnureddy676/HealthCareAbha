package com.iiitb.healthcare_abha.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="patient")
public class Patient implements UserDetails {

    /*@Column(name = "patient_id")

    Long patient_id;*/


    /*@Column(name = "abha_id",nullable = false)
    String abha_id;

    @Column(name = "aadhar_id")
    int aadhar_id;

    @Column(name = "patient_name")
    String patient_name;
    @Column(name = "mobile_number",nullable = false)
    int mobile_number;

    @Column(name = "email")
    String email;
    @Column(name = "password",nullable = false)
    String password;*/


    @Column(name = "user_type")
    private String userType = "patient";

    @Column(name = "patient_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long patientID;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "abha_id")
    private String abhaID;

    @Column(name = "mobile")
    private long mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password = "password";

    @Column(name = "gender")
    private String gender;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "dob")
    private String DOB;

    @Column(name = "address")
    private String address;

    @Column(name = "image")
    private String image;

    @Column(name = "details")
    private String details;

    @Column(name = "date")
    private String date;

   @JsonIgnore
    @OneToMany(cascade =CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name ="patient_id")
    private List<Reports> patient_reports;

@JsonIgnore
    @OneToMany(cascade =CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name ="patientId")
    private List<LinkingToken> linkingTokens;


 /*  @OneToMany(cascade =CascadeType.REMOVE,fetch =FetchType.LAZY)
    @JoinColumn(name ="patientID")
    private List<Patient_visit> patient_visits;*/


    @JsonIgnore
    @OneToMany(cascade=CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name="patientID")
    private List<Appointements> appointments;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roles= new ArrayList<>();
        roles.add(this.getUserType());

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
