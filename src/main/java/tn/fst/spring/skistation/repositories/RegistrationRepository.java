package tn.fst.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.fst.spring.skistation.entities.Course;
import tn.fst.spring.skistation.entities.Registration;
import tn.fst.spring.skistation.entities.Skier;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    
    List<Registration> findByNumWeek(int numWeek);
    
    List<Registration> findBySkier(Skier skier);
    
    List<Registration> findByCourse(Course course);
    
    List<Registration> findBySkierAndNumWeek(Skier skier, int numWeek);
    
    @Query("SELECT r FROM Registration r WHERE r.course.support = :support")
    List<Registration> findByCourseSupport(@Param("support") String support);
    
    @Query("SELECT r FROM Registration r WHERE r.skier.lastName = :lastName AND r.course.typeCourse = :courseType")
    List<Registration> findBySkierLastNameAndCourseType(@Param("lastName") String lastName, @Param("courseType") String courseType);
    
    @Query("SELECT r.course, COUNT(r) FROM Registration r GROUP BY r.course ORDER BY COUNT(r) DESC")
    List<Object[]> findMostRegisteredCourses();
    
    @Query(value = "SELECT r.* FROM registration r JOIN skier s ON r.skier_num_skier = s.num_skier " +
                  "WHERE s.date_of_birth BETWEEN :startDate AND :endDate", 
           nativeQuery = true)
    List<Registration> findBySkierDateOfBirthBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}