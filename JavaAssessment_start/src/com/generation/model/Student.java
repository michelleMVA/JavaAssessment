package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Student
    extends Person
    implements Evaluation
{
    private String studentId, studentName, studentEmail;
    private Date studentBirthDate;
    float PASS_MIN_GRADE = 3.0f;
    private ArrayList<Course> enrolledCourses;
    private ArrayList<Course> listCourse;
    private ArrayList<Course> passedCourse;

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
        studentId=id;
        studentName = name;
        studentEmail = email;
        studentBirthDate = birthDate;
        //create an empty enrolledCourses ArrayList
        enrolledCourses = new ArrayList<>();
    }

    public String getId() {
        return studentId;
    }

    public String getName() {
        return studentName;
    }

    public String getEmail() {
        return studentEmail;
    }

    public Date getBirthDate() { return studentBirthDate; }

    public void enrollToCourse(Course course)
    {
        //TODO
        enrolledCourses.add(course);
    }

    @Override
    public List<Course> findPassedCourses()
    {
        //TODO
        listCourse = new ArrayList<>();
        passedCourse = new ArrayList<>();

        for(int i = 0; i < enrolledCourses.size(); i++) {
            listCourse.add(enrolledCourses.get(i));
        }
        for(int i = 0; i < listCourse.size(); i++){
            Course course = listCourse.get(i);
            if(course.getGrade() >= 3.0) {
                passedCourse.add(course);
            }
        }
        return passedCourse;
    }

    public Course findCourseById( String courseId )
    {
        //TODO
        for(int i=0; i< enrolledCourses.size(); i++){
            Course selectedCourse = enrolledCourses.get(i);
            if(selectedCourse.getCode().equals(courseId)){
               return selectedCourse;
            }
        }
        return null;
    }

    //Added method to update course grade
    public void addGrade(Course c, Double g){
        if(enrolledCourses.contains(c)){
            c.addCourseGrade(g);
        }
    }

    @Override
    public List<Course> getEnrolledCourses()
    {
        //TODO
        return this.enrolledCourses;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
