package com.example.wbdvsp20tsnaikserverjava.services;

import com.example.wbdvsp20tsnaikserverjava.models.Topic;
import com.example.wbdvsp20tsnaikserverjava.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
  @Autowired
  TopicRepository topicRepository;

  public Topic createTopic(String lessonId, Topic topic) {
    topic.setLessonId(lessonId);
    topicRepository.save(topic);
    return topic;
  }

  public List<Topic> findTopicsForLesson(String lessonId) {
    return topicRepository.findTopicsForLesson(lessonId);
  }

  public List<Topic> findAllTopics() {
    return topicRepository.findAllTopics();
  }

  public Topic findTopicById(Integer id) {
    return topicRepository.findById(id).orElse(null);
  }

  public int updateTopic(Integer topicId, Topic updateTopic) {
    Topic topic = topicRepository.findById(topicId).orElseThrow(IllegalArgumentException::new);
    updateTopic.setLessonId(topic.getLessonId());
    topicRepository.save(updateTopic);
    return 1;
  }

  public int deleteTopic(Integer topicId) {
    topicRepository.deleteById(topicId);
    return 1;
  }

}
