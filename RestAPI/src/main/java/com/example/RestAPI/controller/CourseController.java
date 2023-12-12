package com.example.RestAPI.controller;

import com.example.RestAPI.entity.Course;
import com.example.RestAPI.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

@GetMapping("/Course/{id}")
    public Course getCourseById(@PathVariable Integer id){
    return courseService.findById(id);
}
@GetMapping("/allCourses")
public List<Course> getAllCourses (){
    return courseService.getAllCourses();
}
@GetMapping("/Ciourse/{name}")
public Course findByName(@PathVariable String name ){
    return courseService.findByName(name);
}
@PostMapping("/addCourse")
public Course addCourse (@RequestBody Course course){
    return courseService.addCourse(course);
}
@PutMapping("/updateCourse")
public ResponseEntity<?> updateCourse (Course course){
    Course updatedCourse = courseService.updateCourse(course);
    if (updatedCourse==null) return new ResponseEntity<String>("Course not found", HttpStatus.NOT_FOUND);
    else
        return new ResponseEntity<Course>(updatedCourse,HttpStatus.OK);
}

@DeleteMapping("/deleteCourse/{id}")
public String deleteById (@PathVariable Integer id){
    courseService.deleteCourseById(id);
    return "Course deleted ";
}
@DeleteMapping("/deleteAllCourses")
        public String deleteAll (){
    courseService.deleteAllCourses();
    return "Courses deleted";

        }
}
