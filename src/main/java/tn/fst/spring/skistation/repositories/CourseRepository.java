package tn.fst.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.fst.spring.skistation.entities.Course;
import tn.fst.spring.skistation.entities.Support;
import tn.fst.spring.skistation.entities.TypeCourse;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
    List<Course> findByLevel(int level);
    
    List<Course> findByTypeCourse(TypeCourse typeCourse);
    
    List<Course> findBySupport(Support support);
    
    List<Course> findByPriceLessThan(float maxPrice);
    
    List<Course> findByTimeSlot(int timeSlot);
    
    @Query("SELECT c FROM Course c WHERE c.typeCourse = :type AND c.support = :support")
    List<Course> findCoursesByTypeAndSupport(@Param("type") TypeCourse typeCourse, 
                                            @Param("support") Support support);
    
    @Query("SELECT c, COUNT(r) FROM Course c LEFT JOIN c.registrations r GROUP BY c")
    List<Object[]> findCoursesWithRegistrationCount();
    
    @Query("SELECT c FROM Course c WHERE c.price BETWEEN :minPrice AND :maxPrice")
    List<Course> findCoursesByPriceRange(@Param("minPrice") float minPrice, 
                                        @Param("maxPrice") float maxPrice);
    
    @Query(value = "SELECT c.* FROM course c LEFT JOIN registration r ON c.num_course = r.course_num_course " +
                  "GROUP BY c.num_course HAVING COUNT(r.num_registration) >= :minRegistrations", 
           nativeQuery = true)
    List<Course> findCoursesWithMinRegistrations(@Param("minRegistrations") int minRegistrations);
}