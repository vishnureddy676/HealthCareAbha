package com.iiitb.healthcare_abha.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;


@Data
@Entity
@Table(name="frontdesk")
public class FrontDesk {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
   private long front_desk_id;


 @MapsId
 @JoinColumn(name = "front_desk_id")
 @OneToOne(cascade = CascadeType.ALL)
 private Employee employee;

    @Column(name = "frontdesk_shift_start")
    private String frontdesk_shift_start;

    @Column(name = "frontdesk_shift_end")

    private String frontdesk_shift_end;
    @Column(name="details")
    private String details;


}
