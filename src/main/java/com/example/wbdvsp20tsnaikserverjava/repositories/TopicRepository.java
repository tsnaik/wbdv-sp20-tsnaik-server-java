package com.example.wbdvsp20tsnaikserverjava.repositories;

import com.example.wbdvsp20tsnaikserverjava.models.Topic;
import com.example.wbdvsp20tsnaikserverjava.models.Widget;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository
        extends CrudRepository<Topic, Integer> {

  //   SELECT * FROM widgets WHERE topic_id=tid
  @Query(value = "SELECT * FROM topics WHERE topics.lesson_id=:lid", nativeQuery = true)
  List<Topic> findTopicsForLesson(@Param("lid") String lessonId);

  @Query(value = "SELECT * FROM topics", nativeQuery = true)
  List<Topic> findAllWidgets();

  @Query(value = "SELECT * FROM topics WHERE id=:tid", nativeQuery = true)
  Topic findWidgetById(@Param("wid") Integer topicId);
}
