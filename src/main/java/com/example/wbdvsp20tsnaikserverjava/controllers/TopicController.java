package com.example.wbdvsp20tsnaikserverjava.controllers;

import com.example.wbdvsp20tsnaikserverjava.models.Topic;
import com.example.wbdvsp20tsnaikserverjava.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

  @Autowired
  TopicService service;

  @PostMapping("/api/lessons/{lid}/topics")
  public Topic createTopic(@PathVariable("lid") String lid, @RequestBody Topic topic) {
    return service.createTopic(lid, topic);
  }

  @PutMapping("/api/topics/{tid}")
  public int updateTopic(@PathVariable("tid") Integer tid, @RequestBody Topic topic) {
    return service.updateTopic(tid, topic);
  }

  @DeleteMapping("/api/topics/{topicId}")
  public int deleteTopic(@PathVariable("topicId") Integer tid) {
    return service.deleteTopic(tid);
  }

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return service.findAllTopics();
  }

  @GetMapping("/api/topics/{topicId}")
  public Topic findTopicById(@PathVariable("topicId") Integer tid) {
    return service.findTopicById(tid);
  }

  @GetMapping("/api/lessons/{lid}/topics")
  public List<Topic> findTopicsForTopic(
          @PathVariable("lid") String lessonId) {
    return service.findTopicsForLesson(lessonId);
  }
}
