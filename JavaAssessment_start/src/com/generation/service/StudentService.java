package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService {
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent(Student student) {
        //TODO
        Student newStudent = new Student(student.getId(), student.getName(), student.getEmail(), student.getBirthDate());
        students.put(student.getId(), newStudent);
    }

    public Student findStudent(String studentId) {
        //TODO
        Student selectedStudent = students.get(studentId);
        return selectedStudent;
    }

    public boolean showSummary() {
        //TODO
        for(Student s: students.values()){
            System.out.println(s);
            System.out.println("Enrolled Courses:");
            for(Course c: s.getEnrolledCourses()){
                System.out.println(c);
            }
        }
        return true;
    }

    public void enrollToCourse(String studentId, Course course) {
        //TODO
        if (students.get(studentId) == null) {
            System.out.println("Enroll Failed. Student could not be found.");
        } else if (course.getCode() == null) {
            System.out.println("Enroll Failed. Course could not be found.");
        } else {
            Student student = students.get(studentId);
            student.enrollToCourse(course);
        }
    }
}
