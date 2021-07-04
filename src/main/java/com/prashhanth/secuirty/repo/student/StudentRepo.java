package com.prashhanth.secuirty.repo.student;

import com.prashhanth.secuirty.entity.relation.Student;
import com.prashhanth.secuirty.entity.relation.dto.StudentLapName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query("select new com.prashhanth.secuirty.entity.relation.dto.StudentLapName(s.sname,l.lname) from Student s JOIN s.laptop l")
    public List<StudentLapName> getStudentLapTopName();

}
