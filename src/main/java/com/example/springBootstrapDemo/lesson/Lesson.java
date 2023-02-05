package com.example.springBootstrapDemo.lesson;

import com.example.springBootstrapDemo.course.Course;
import com.example.springBootstrapDemo.topic.Topic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lesson {
    @Id
    private  String id;
    private String name;
    private String body;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Lesson() {
    }

    public Lesson(String id, String name, String body, String courseId, String titleId) {
        super();
        this.id = id;
        this.name = name;
        this.body = body;
        this.course = new Course(courseId, "", "", titleId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
