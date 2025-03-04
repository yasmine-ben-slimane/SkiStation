package tn.fst.spring.skistation.services;

import tn.fst.spring.skistation.entities.Course;
import tn.fst.spring.skistation.entities.Support;
import tn.fst.spring.skistation.entities.TypeCourse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICourseService {
    
    Course addCourse(Course course);
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id);
    Course updateCourse(Course course);
    void deleteCourse(Long id);
    
    List<Course> findByLevel(int level);
    List<Course> findByTypeCourse(TypeCourse typeCourse);
    List<Course> findBySupport(Support support);
    List<Course> findByPriceLessThan(float maxPrice);
    List<Course> findByTimeSlot(int timeSlot);
    List<Course> findCoursesByTypeAndSupport(TypeCourse typeCourse, Support support);
    Map<Course, Long> getCoursesWithRegistrationCount();
    List<Course> findCoursesByPriceRange(float minPrice, float maxPrice);
    List<Course> findCoursesWithMinRegistrations(int minRegistrations);
}