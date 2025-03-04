package tn.fst.spring.skistation.services;

import tn.fst.spring.skistation.entities.Instructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IInstructorService {
    
    Instructor addInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Optional<Instructor> getInstructorById(Long id);
    Instructor updateInstructor(Instructor instructor);
    void deleteInstructor(Long id);
    
    List<Instructor> findByFirstName(String firstName);
    List<Instructor> findByLastName(String lastName);
    List<Instructor> findByDateOfHireAfter(Date date);
    List<Instructor> findByFirstNameAndLastName(String firstName, String lastName);
    List<Instructor> findInstructorsWithMinimumCourses(int coursesCount);
    List<Instructor> findInstructorsByCourseSupportType(String support);
    List<Instructor> findInstructorsHiredBetweenDates(Date startDate, Date endDate);
}