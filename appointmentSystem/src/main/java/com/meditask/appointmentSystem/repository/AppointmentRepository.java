package com.meditask.appointmentSystem.repository;

import com.meditask.appointmentSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    /**
     * Find all appointments that are not marked as deleted.
     *
     * @param isDelete the deletion status (0 for active, 1 for deleted)
     * @return a list of all active appointments
     */
    List<Appointment> findByIsDelete(int isDelete);

}
