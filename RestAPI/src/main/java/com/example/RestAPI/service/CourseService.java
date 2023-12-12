package com.example.RestAPI.service;

import com.example.RestAPI.dto.UserDto;
import com.example.RestAPI.entity.User;
import com.example.RestAPI.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.RestAPI.entity.Course;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;


    public Course findById(int id) {
        return repository.findById(id).orElse(null);

    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course addCourse(Course course) {
        return repository.save(course);
    }


    public Course updateCourse(Course course){
        Course existingcourse = repository.findById(course.getCourseid()).orElse(null) ;

        if (existingcourse==null) return null;

        existingcourse.setName(course.getName());
        existingcourse.setDescription(course.getDescription());
        existingcourse.setLecturer(course.getLecturer());
        existingcourse.setLocation(course.getLocation());
        existingcourse.setTime(course.getTime());
        existingcourse.setNumberofstudents(course.getNumberofstudents());
        existingcourse.setRating(course.getRating());
        return repository.save(existingcourse);
    }
    public String deleteAllCourses (){
        repository.deleteAll();
        return "Deleted!";

    }
    public String deleteCourseById(int id){
        repository.deleteById(id);
        return "Course deleted!";

    }
    public List<Course> findByName(String name){
        return repository.findByName(name);
    }


}

