package be.abis.projectING.repository;

import be.abis.projectING.exception.CourseAlreadyExistsException;
import be.abis.projectING.model.Course;
import be.abis.projectING.model.Participant;
import be.abis.projectING.model.Person;
import be.abis.projectING.model.SessionRegistration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/*
Repository for courses + session registrations
This repository contains test data for both, since session registrations cannot exist independently from courses
During repository creation, a new list of courses is initialised.
For each course, a list of session registrations is also automatically generated (see method 'generateRegistrationsForCourse')
It also already contains some helper methods that can be useful down the line
 */
public class CoursesRegistrationsRepository {
    private List<Course> courseList;
    private static final PersonRepository personRepository = new PersonRepository();

    public CoursesRegistrationsRepository(){
        courseList = new ArrayList<>();
        Person person1 = new Participant("Tim");
        Course course1 = new Course(1, "Java Advanced", LocalDate.of(2023,10,1),LocalDate.of(2023,10,6));
        generateRegistrationsForCourse(course1, personRepository.getPersonList().get(0));
        try {
            this.addCourseToList(course1);
        } catch (CourseAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        Person person2 = new Participant("Sandy");
        Course course2 = new Course(2, ".NET Basic", LocalDate.of(2024,8,20),LocalDate.of(2024,8,24));
        generateRegistrationsForCourse(course2, personRepository.getPersonList().get(1));
        try {
            this.addCourseToList(course2);
        } catch (CourseAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        Course course3 = new Course(3, "Python", LocalDate.of(2023,8,8),LocalDate.of(2023,8,16));
        generateRegistrationsForCourse(course3, personRepository.getPersonList().get(0));
        try {
            this.addCourseToList(course3);
        } catch (CourseAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        Course course4 = new Course(4, "Javascript", LocalDate.of(2024,11,12),LocalDate.of(2024,11,14));
        generateRegistrationsForCourse(course4, personRepository.getPersonList().get(2));
        try {
            this.addCourseToList(course4);
        } catch (CourseAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    // Helper method to generate session registrations for a given course: 1 registration is generated for each course day
    public void generateRegistrationsForCourse(Course c, Person p){
        for(int i = 0; i <= ChronoUnit.DAYS.between(c.getStartDate(), c.getEndDate()); i++){
            c.addRegistrationToCourse(new SessionRegistration(c, p, c.getStartDate().plusDays(i)));
        }
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    // Helper method to return a course based on ID reference. Default test data contains IDs 1 to 4
    public Course getCourseById(int id){
        for(Course c:courseList){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    // Return all courses for a given year. Can later be used to calculate order total for a year
    public List<Course> getAllCoursesForYear(int year){
        return courseList.stream()
                .filter(c -> c.getStartDate().getYear() == year)
                .toList();
    }

    // Helper method to get a list of all session registrations for a course based on course ID
    public List<SessionRegistration> getSessionRegistrationsForCourse(int id){
        return courseList.stream()
                .filter(c -> c.getId() == id)
                .toList()
                .stream().findFirst()
                .get().getSessionRegistrations();
    }

    // Method to add a new course to the list, with a check that ID is not duplicated
    // Throws a custom exception in case a course with the given ID already exists
    public void addCourseToList(Course c) throws CourseAlreadyExistsException {
        for(Course entry:this.courseList){
            if (entry.getId() == c.getId()){
                throw new CourseAlreadyExistsException("Course with ID " + c.getId() + " already exists.");
            }
        }
        this.courseList.add(c);
    }
}
