package com.example.wbdvsp20tsnaikserverjava.repositories;

import com.example.wbdvsp20tsnaikserverjava.models.Widget;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {

  //   SELECT * FROM widgets WHERE topic_id=tid
  @Query(value = "SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
  List<Widget> findWidgetsForTopic(@Param("tid") Integer topicId);

  @Query(value = "SELECT * FROM widgets", nativeQuery = true)
  List<Widget> findAllWidgets();

  @Query(value = "SELECT * FROM widgets WHERE id=:wid", nativeQuery = true)
  Widget findWidgetById(@Param("wid") Integer widgetId);
}
