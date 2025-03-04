package tn.fst.spring.skistation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.fst.spring.skistation.entities.Instructor;
import tn.fst.spring.skistation.repositories.InstructorRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements IInstructorService {
    
    @Autowired
    private InstructorRepository instructorRepository;
    
    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
    
    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }
    
    @Override
    public Optional<Instructor> getInstructorById(Long id) {
        return instructorRepository.findById(id);
    }
    
    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
    
    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }
    
    @Override
    public List<Instructor> findByFirstName(String firstName) {
        return instructorRepository.findByFirstName(firstName);
    }
    
    @Override
    public List<Instructor> findByLastName(String lastName) {
        return instructorRepository.findByLastName(lastName);
    }
    
    @Override
    public List<Instructor> findByDateOfHireAfter(Date date) {
        return instructorRepository.findByDateOfHireAfter(date);
    }
    
    @Override
    public List<Instructor> findByFirstNameAndLastName(String firstName, String lastName) {
        return instructorRepository.findByFirstNameAndLastName(firstName, lastName);
    }
    
    @Override
    public List<Instructor> findInstructorsWithMinimumCourses(int coursesCount) {
        return instructorRepository.findInstructorsWithMinimumCourses(coursesCount);
    }
    
    @Override
    public List<Instructor> findInstructorsByCourseSupportType(String support) {
        return instructorRepository.findInstructorsByCourseSupportType(support);
    }
    
    @Override
    public List<Instructor> findInstructorsHiredBetweenDates(Date startDate, Date endDate) {
        return instructorRepository.findInstructorsHiredBetweenDates(startDate, endDate);
    }
}