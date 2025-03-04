package tn.fst.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.fst.spring.skistation.entities.Instructor;

import java.util.Date;
import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    
    List<Instructor> findByFirstName(String firstName);
    
    List<Instructor> findByLastName(String lastName);
    
    List<Instructor> findByDateOfHireAfter(Date date);
    
    List<Instructor> findByFirstNameAndLastName(String firstName, String lastName);
    
    @Query("SELECT i FROM Instructor i WHERE SIZE(i.courses) >= :coursesCount")
    List<Instructor> findInstructorsWithMinimumCourses(@Param("coursesCount") int coursesCount);
    
    @Query("SELECT DISTINCT i FROM Instructor i JOIN i.courses c WHERE c.support = :support")
    List<Instructor> findInstructorsByCourseSupportType(@Param("support") String support);
    
    @Query(value = "SELECT * FROM instructor WHERE date_of_hire BETWEEN :startDate AND :endDate", 
           nativeQuery = true)
    List<Instructor> findInstructorsHiredBetweenDates(@Param("startDate") Date startDate, 
                                                    @Param("endDate") Date endDate);
}