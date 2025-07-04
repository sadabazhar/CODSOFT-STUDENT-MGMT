package main.controller;

import main.dao.StudentDAO;
import main.model.Student;

import java.util.List;

public class StudentController {
    private StudentDAO dao = new StudentDAO();

    public boolean addStudent(Student s) {
        return validate(s) && dao.addStudent(s);
    }

    public boolean updateStudent(Student s) {
        return validate(s) && dao.updateStudent(s);
    }

    public boolean deleteStudent(String rollNo) {
        return dao.deleteStudent(rollNo);
    }

    public Student getStudent(String rollNo) {
        return dao.getStudent(rollNo);
    }

    public List<Student> getAllStudents() {
        return dao.getAllStudents();
    }

    private boolean validate(Student s) {
        return !(s.getRollNo().isBlank() || s.getName().isBlank() ||
                 s.getGrade().isBlank() || s.getEmail().isBlank() ||
                 s.getPhone().isBlank());
    }
}
