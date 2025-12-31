package com.example.JPADemo.Service;

import com.example.JPADemo.Model.Student;
import com.example.JPADemo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentByRno(int rno) {
        return studentRepository.findById(rno).orElse(new Student());
    }

    public String addStudent(Student student) {
         studentRepository.save(student);
        return "Added...";
    }

    public String addListOfStudents(List<Student> students){
        studentRepository.saveAll(students);
        return "Added all Students...";
    }

    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "Updated...";
    }

    public String deleteStudentByRno(int rno) {
        studentRepository.deleteById(rno);
        return "Deleted...";
    }

    public String deleteAllStudents() {
        studentRepository.deleteAll();
        return "Deleted All Students...";
    }


    public List<Student> getStudentsByTechnology(String technology) {
        return studentRepository.findByTechnology(technology);
    }

    public List<Student> getStudentsByGenderAndTechnology(String gender, String tech) {
        return studentRepository.findByGenderAndTechnology(gender,tech);
    }
}
