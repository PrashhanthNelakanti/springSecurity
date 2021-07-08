package com.prashhanth.secuirty.tx;

import com.prashhanth.secuirty.entity.Appointment;
import com.prashhanth.secuirty.entity.Patient;
import com.prashhanth.secuirty.repo.laptop.AppointmentRepo;
import com.prashhanth.secuirty.repo.laptop.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HospitalService {

    @Autowired
    PatientRepo patientRepo;
    @Autowired
    AppointmentRepo appointmentRepo;

    @Transactional
    public String registerPatient(HopitalDto hospitaldto) {
        Patient patient = hospitaldto.getPatient();
        patientRepo.save(patient);
        if (patient.getPatientName().equals("Joker"))
            throw new RuntimeException();
        Appointment appointment = hospitaldto.getAppointment();
        appointmentRepo.save(appointment);
        return "Patient Registered For appointment";
    }
}
