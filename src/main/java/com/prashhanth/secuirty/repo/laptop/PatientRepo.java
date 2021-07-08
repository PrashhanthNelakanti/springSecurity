package com.prashhanth.secuirty.repo.laptop;

import com.prashhanth.secuirty.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {
}
