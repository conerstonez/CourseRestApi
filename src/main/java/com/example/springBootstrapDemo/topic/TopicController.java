package com.example.springBootstrapDemo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController public class TopicController {

    @Autowired private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable("id") String  id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void  addTopic(@RequestBody Topic course) {
        topicService.addTopic(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void  updateTopic(@RequestBody Topic course, @PathVariable String id) {
        topicService.updateTopic(id, course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
