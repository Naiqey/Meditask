package com.meditask.appointmentSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String doctorName;
    private String date;
    private String time;
    private int isDelete = 0;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
