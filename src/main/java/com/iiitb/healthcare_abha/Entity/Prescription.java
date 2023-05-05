package com.iiitb.healthcare_abha.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "prescription")
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "hospital_name")),
            @AttributeOverride(name = "street", column = @Column(name = "hospital_street")),
            @AttributeOverride(name = "city", column = @Column(name = "hospital_city")),
            @AttributeOverride(name = "state", column = @Column(name = "hospital_state")),
            @AttributeOverride(name = "pincode", column = @Column(name = "hospital_pincode")),
            @AttributeOverride(name = "phone", column = @Column(name = "hospital_phone"))
    })
    private Hospital hospital;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "diagnosis", column = @Column(name = "med_diagnosis")),
            @AttributeOverride(name = "name", column = @Column(name = "med_name")),
            @AttributeOverride(name = "type", column = @Column(name = "med_type")),
            @AttributeOverride(name = "quantity", column = @Column(name = "med_quantity")),
            @AttributeOverride(name = "duration", column = @Column(name = "med_duration"))
    })
    private Medicine medicine;

    @Column(name = "doc_name", nullable = false)
    private String docName;

    @Column(name = "front_desk_name", nullable = false)
    private String frontDeskName;

    @Column(name = "advice")
    private String advice;

    @Column(name = "total", nullable = false)
    private double total;

    // Other fields and getters/setters

    @Embeddable
    public static class Hospital {
        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "street", nullable = false)
        private String street;

        @Column(name = "city", nullable = false)
        private String city;

        @Column(name = "state", nullable = false)
        private String state;

        @Column(name = "pincode", nullable = false)
        private int pincode;

        @Column(name = "phone", nullable = false)
        private long phone;

        // Getters/setters
    }

    @Embeddable
    public static class Medicine {
        @Column(name = "diagnosis")
        private String diagnosis;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "type", nullable = false)
        private String type;

        @Column(name = "quantity", nullable = false)
        private int quantity;

        @Column(name = "duration", nullable = false)
        private int duration;

        // Getters/setters
    }
}
