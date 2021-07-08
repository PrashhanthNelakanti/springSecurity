package com.prashhanth.secuirty.entity.relation.dto;

import com.prashhanth.secuirty.entity.relation.Inventory;
import com.prashhanth.secuirty.entity.relation.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInvDto {

    private Student student;
    private Inventory inventory;
}
