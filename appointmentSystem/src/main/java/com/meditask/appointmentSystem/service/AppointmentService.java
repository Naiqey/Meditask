package com.meditask.appointmentSystem.service;

import com.meditask.appointmentSystem.entity.Appointment;
import com.meditask.appointmentSystem.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    /**
     * Create a new appointment.
     *
     * @param appointment the appointment to create
     * @return the created appointment
     */
    public Appointment createAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    /**
     * Get all appointments that are not marked as deleted.
     *
     * @return a list of all active appointments
     */
    public List<Appointment> getAllAppointments() {
        return repository.findByIsDelete(0);
    }

    /**
     * Get an appointment by its ID if it is not marked as deleted.
     *
     * @param id the ID of the appointment to retrieve
     * @return an optional containing the appointment if found and active, otherwise empty
     */
    public Optional<Appointment> getAppointmentById(Long id) {
        return repository.findById(id).filter(appointment -> appointment.getIsDelete() == 0);
    }

    /**
     * Mark an appointment as deleted by its ID.
     *
     * @param id the ID of the appointment to delete
     * @return true if the appointment was found and marked as deleted, false otherwise
     */
    public boolean deleteAppointment(Long id) {
        Optional<Appointment> appointmentOpt = repository.findById(id);
        if (appointmentOpt.isPresent() && appointmentOpt.get().getIsDelete() == 0) {
            Appointment appointment = appointmentOpt.get();
            appointment.setIsDelete(1);  // Mark as deleted
            repository.save(appointment);
            return true;
        }
        return false;
    }
}
