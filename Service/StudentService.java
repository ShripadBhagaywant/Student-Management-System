package com.StudentManagementSystem.service;

import com.StudentManagementSystem.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {

    // Abstract methods :-

    public List<Student> getAllStudents();

    public  Student saveStudent(Student student);

    public Student getById(int id);

    public void deleteById(int id);
}
