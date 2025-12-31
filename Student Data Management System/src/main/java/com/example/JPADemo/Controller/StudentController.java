package com.example.JPADemo.Controller;

import com.example.JPADemo.Model.Student;
import com.example.JPADemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{rno}")
    public Student getStudentByRno(@PathVariable("rno") int rno){
        return studentService.getStudentByRno(rno);
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

   @PostMapping("/students/addAll")
    public String addListOfStudents(@RequestBody List<Student> students){
        return studentService.addListOfStudents(students);
    }

    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{rno}")
    public String deleteStudentByRno(@PathVariable("rno") int rno){
        return studentService.deleteStudentByRno(rno);
    }

    @DeleteMapping("/students/clear")
    public String deleteAllStudents(){
        return studentService.deleteAllStudents();
    }

    @GetMapping("/students/technology/{tech}")
    public List<Student> getStudentsByTechnology(@PathVariable("tech") String technology){
        return studentService.getStudentsByTechnology(technology);
    }

    //NATIVE QUERY MAPPING
    @GetMapping ("/students/filter")
    public List<Student> getStudentsByGenderAndTechnology(@RequestParam ("gender")String gender,
                                                          @RequestParam("technology") String tech){
        return studentService.getStudentsByGenderAndTechnology(gender,tech);
    }
}
