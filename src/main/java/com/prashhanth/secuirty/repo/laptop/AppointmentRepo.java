package com.prashhanth.secuirty.repo.laptop;

import com.prashhanth.secuirty.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {
}
