package com.StudentManagementSystem.controller;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@Controller :- Handel req is come for the server does not handle rest api.
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired//Inject services.
   private StudentService studentService;

    @GetMapping("/home")
    public String home()
    {
        return "home"; //View page html file -> home.html
    }

    @GetMapping("/students")
    public String getAllStudents(Model model)
    {
        //Model is interface it all Student  data from database and send to view on user.
        model.addAttribute("students",studentService.getAllStudents());
        return  "students";//students.html page.
    }

    @GetMapping("students/new")
    public String createStudentFrom(Model model)
    {
        Student student = new Student();//hold the student object.
        model.addAttribute("student",student);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student")Student student)
    {
       studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("students/edit/{id}")
    public String editStudentForm(@PathVariable  int id , Model model)
    {
        model.addAttribute("student",studentService.getById(id));
        return "edit_student";
    }


    @PostMapping("/students/edit/{id}")
    public  String updateStudent(@PathVariable  int id,@ModelAttribute("student") Student student)
    {
        Student exitingStudent  = studentService.getById(id);
        exitingStudent.setFirstName(student.getFirstName());
        exitingStudent.setLastName(student.getLastName());
        exitingStudent.setEmail(student.getEmail());

         studentService.saveStudent(exitingStudent);

         return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id)
    {
        studentService.deleteById(id);
        return "redirect:/students";
    }
}
