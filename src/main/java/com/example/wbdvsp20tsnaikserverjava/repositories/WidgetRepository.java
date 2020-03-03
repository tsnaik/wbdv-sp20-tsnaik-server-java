package com.example.wbdvsp20tsnaikserverjava.repositories;

import com.example.wbdvsp20tsnaikserverjava.models.Widget;

import org.springframework.data.repository.CrudRepository;

public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {

  // SELECT * FROM widgets WHERE topic_id=tid
//  @Query(value = "SELECT * FROM widgets WHERE topic_id=:tid",
//          nativeQuery = true)
//  public List<Widget> findWidgetsForTopic
//  (@Param("tid") Integer topicId);
}
