package com.meditask.appointmentSystem.controller;

import com.meditask.appointmentSystem.entity.Appointment;
import com.meditask.appointmentSystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    /**
     * Create a new appointment.
     *
     * @param appointment the appointment to create
     * @return the created appointment
     */
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return service.createAppointment(appointment);
    }

    /**
     * Get all appointments.
     *
     * @return a list of all appointments
     */
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    /**
     * Get an appointment by its ID.
     *
     * @param id the ID of the appointment to retrieve
     * @return the appointment if found, otherwise a 404 response
     */
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = service.getAppointmentById(id);
        return appointment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Delete an appointment by its ID.
     *
     * @param id the ID of the appointment to delete
     * @return a response entity with a success or error message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        boolean isDeleted = service.deleteAppointment(id);
        if (isDeleted) {
            return ResponseEntity.ok("Appointment deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Appointment not found or already deleted.");
        }
    }
}
