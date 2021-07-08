package com.prashhanth.secuirty.tx;

import com.prashhanth.secuirty.entity.Appointment;
import com.prashhanth.secuirty.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class HopitalDto {
    private Patient patient;
    private Appointment appointment;
}
