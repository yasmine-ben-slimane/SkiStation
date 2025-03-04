package tn.fst.spring.skistation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.fst.spring.skistation.entities.Course;
import tn.fst.spring.skistation.entities.Registration;
import tn.fst.spring.skistation.entities.Skier;
import tn.fst.spring.skistation.repositories.RegistrationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements IRegistrationService {
    
    @Autowired
    private RegistrationRepository registrationRepository;
    
    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }
    
    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
    
    @Override
    public Optional<Registration> getRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }
    
    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }
    
    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
    
    @Override
    public List<Registration> findByNumWeek(int numWeek) {
        return registrationRepository.findByNumWeek(numWeek);
    }
    
    @Override
    public List<Registration> findBySkier(Skier skier) {
        return registrationRepository.findBySkier(skier);
    }
    
    @Override
    public List<Registration> findByCourse(Course course) {
        return registrationRepository.findByCourse(course);
    }
    
    @Override
    public List<Registration> findBySkierAndNumWeek(Skier skier, int numWeek) {
        return registrationRepository.findBySkierAndNumWeek(skier, numWeek);
    }
    
    @Override
    public List<Registration> findByCourseSupport(String support) {
        return registrationRepository.findByCourseSupport(support);
    }
    
    @Override
    public List<Registration> findBySkierLastNameAndCourseType(String lastName, String courseType) {
        return registrationRepository.findBySkierLastNameAndCourseType(lastName, courseType);
    }
    
    @Override
    public Map<Course, Long> getMostRegisteredCourses() {
        List<Object[]> results = registrationRepository.findMostRegisteredCourses();
        Map<Course, Long> coursesWithCount = new HashMap<>();
        
        for (Object[] result : results) {
            Course course = (Course) result[0];
            Long count = (Long) result[1];
            coursesWithCount.put(course, count);
        }
        
        return coursesWithCount;
    }
    
    @Override
    public List<Registration> findBySkierDateOfBirthBetween(String startDate, String endDate) {
        return registrationRepository.findBySkierDateOfBirthBetween(startDate, endDate);
    }
}