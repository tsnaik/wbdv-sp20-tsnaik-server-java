package com.example.wbdvsp20tsnaikserverjava.services;

import com.example.wbdvsp20tsnaikserverjava.models.Topic;
import com.example.wbdvsp20tsnaikserverjava.models.Widget;
import com.example.wbdvsp20tsnaikserverjava.repositories.TopicRepository;
import com.example.wbdvsp20tsnaikserverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {
  @Autowired
  WidgetRepository widgetRepository;

  @Autowired
  TopicRepository topicRepository;

  public List<Widget> saveAllWidgets(Integer topicId, List<Widget> widgets) {
    int order = 0;
    Optional<Topic> topic = topicRepository.findById(topicId);
    if (!topic.isPresent()) {
      throw new IllegalArgumentException();
    }
    Topic topic1 = topic.get();
    for (Widget widget : widgets) {
      widget.setTopic(topic1);
      widget.setOrdering(order++);
    }
    widgetRepository.saveAll(widgets);
    return widgets;
  }

  public Widget createWidget(Integer topicId, Widget widget) {
    Optional<Topic> topic = topicRepository.findById(topicId);
    if (!topic.isPresent()) {
      throw new IllegalArgumentException();
    }
    widget.setTopic(topic.get());
    Optional<Integer> maxOrder = widgetRepository.findMaxOrderForTopic(topicId);
    widget.setOrdering(maxOrder.orElse(-1) + 1);
    widgetRepository.save(widget);
    return widget;
  }

  public List<Widget> findWidgetsForTopic(Integer topicId) {
    return widgetRepository.findWidgetsForTopic(topicId);
  }

  public List<Widget> findAllWidgets() {
    return widgetRepository.findAllWidgets();
  }

  public Widget findWidgetById(Integer id) {
    return widgetRepository.findById(id).orElse(null);
  }

  public int updateWidget(Integer widgetId, Widget updateWidget) {
    Widget widget = widgetRepository.findById(widgetId).orElseThrow(IllegalArgumentException::new);
    updateWidget.setTopic(widget.getTopic());
    widgetRepository.save(updateWidget);
    return 1;
  }

  public int deleteWidget(Integer widgetId) {
    widgetRepository.deleteById(widgetId);
    return 1;
  }

}
