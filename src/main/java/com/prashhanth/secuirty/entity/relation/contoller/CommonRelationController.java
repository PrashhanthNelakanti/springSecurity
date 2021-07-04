package com.prashhanth.secuirty.entity.relation.contoller;

import com.prashhanth.secuirty.entity.relation.Laptop;
import com.prashhanth.secuirty.entity.relation.Student;
import com.prashhanth.secuirty.entity.relation.dto.StudentDto;
import com.prashhanth.secuirty.entity.relation.dto.StudentLapName;
import com.prashhanth.secuirty.repo.laptop.LaptopRepo;
import com.prashhanth.secuirty.repo.student.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonRelationController {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private LaptopRepo laptopRepo;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody StudentDto studentDto){
        return studentRepo.save(studentDto.getStudent());
    }

    @GetMapping("/student/lap")
    public List<StudentLapName> getStudentLapTop(){
        return studentRepo.getStudentLapTopName();
    }
}
