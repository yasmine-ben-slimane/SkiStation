package tn.fst.spring.skistation.services;

import tn.fst.spring.skistation.entities.Course;
import tn.fst.spring.skistation.entities.Registration;
import tn.fst.spring.skistation.entities.Skier;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IRegistrationService {
    
    Registration addRegistration(Registration registration);
    
    List<Registration> getAllRegistrations();
    
    Optional<Registration> getRegistrationById(Long id);
    
    Registration updateRegistration(Registration registration);
    
    void deleteRegistration(Long id);
    
    List<Registration> findByNumWeek(int numWeek);
    
    List<Registration> findBySkier(Skier skier);
    
    List<Registration> findByCourse(Course course);
    
    List<Registration> findBySkierAndNumWeek(Skier skier, int numWeek);
    
    List<Registration> findByCourseSupport(String support);
    
    List<Registration> findBySkierLastNameAndCourseType(String lastName, String courseType);
    
    Map<Course, Long> getMostRegisteredCourses();
    
    List<Registration> findBySkierDateOfBirthBetween(String startDate, String endDate);
}