package com.example.springBootstrapDemo.course;

import com.example.springBootstrapDemo.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable("id") String id){
        return courseService.getAllCourses(id);
    }

    @GetMapping(value = "/topics/{topicId}/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable("courseId") String courseId) {
        return courseService.getCourse(courseId);
    }

    @PostMapping(value = "/topics/{topicId}/courses")
    public void  addCourse(@RequestBody Course course, @PathVariable("topicId") String  topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @PutMapping(value = "/topics/{topicId}/courses/{courseId}")
    public void  updateCourse(@RequestBody Course course, @PathVariable("topicId") String  topicId, @PathVariable("courseId") String  courseId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @DeleteMapping(value = "/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }

}
