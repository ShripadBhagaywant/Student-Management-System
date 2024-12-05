package com.StudentManagementSystem.respository;

import com.StudentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepository extends JpaRepository<Student,Integer>
{
        //IN this repo  used database operation.

}
