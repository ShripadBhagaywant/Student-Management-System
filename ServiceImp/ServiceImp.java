package com.StudentManagementSystem.serviceImpl;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.respository.Studentrepository;
import com.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements StudentService {

    //Inject student repo.
    @Autowired
    Studentrepository studentrepository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = studentrepository.findAll();
        return list;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentrepository.save(student);
    }

    @Override
    public Student getById(int id) {
        return studentrepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        studentrepository.deleteById(id);
    }
}
