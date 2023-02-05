package com.example.springBootstrapDemo.lesson;

import com.example.springBootstrapDemo.course.Course;
import com.example.springBootstrapDemo.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping(value = "/topics/{topicId}/courses/{id}/lessons")
    public List<Lesson> getAllLessons(@PathVariable("id") String id){
        return lessonService.getAllLessons(id);
    }

    @GetMapping(value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public Optional<Lesson> getLesson(@PathVariable("lessonId") String lessonId) {
        return lessonService.getLesson(lessonId);
    }

    @PostMapping(value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void  addLesson(@RequestBody Lesson lesson, @PathVariable("topicId") String  topicId
            , @PathVariable("courseId") String courseId) {
        lesson.setCourse(new Course(courseId, "", "", topicId));
        lessonService.addLesson(lesson);
    }

    @PutMapping(value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void  updateLesson(@RequestBody Lesson lesson, @PathVariable("topicId") String  topicId
            , @PathVariable("courseId") String  courseId, @PathVariable("lessonId") String lessonId) {
        lesson.setCourse(new Course());
        lessonService.updateLesson(lesson);
    }

    @DeleteMapping(value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void deleteLesson(@PathVariable String lessonId) {
        lessonService.deleteLesson(lessonId);
    }

}
