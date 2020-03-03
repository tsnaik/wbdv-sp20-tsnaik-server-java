package com.example.wbdvsp20tsnaikserverjava.services;

import com.example.wbdvsp20tsnaikserverjava.models.Widget;
import com.example.wbdvsp20tsnaikserverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class WidgetService {
  List<Widget> widgets = new ArrayList<>();

  @Autowired
  WidgetRepository widgetRepository;
  public List<Widget> saveAllWidgets(String topicId, List<Widget> widgets) {
    removeAllWidgets(topicId);
    this.widgets.addAll(widgets);
    return widgets;
  }

  private void removeAllWidgets(String topicId) {
//    widgets = widgets.stream()
//            .filter(w -> !w.getTopicId().equals(topicId)).collect(Collectors.toList());
  }
  public Widget createWidget(String topicId, Widget widget) {
//    widget.setTopicId(topicId);
    widgetRepository.save(widget);
    return widget;
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    List<Widget> resultWidgets = new ArrayList<Widget>();
    for (Widget w : widgets) {
      if (topicId.equals(/*w.getTopicId()*/null)) {
        resultWidgets.add(w);
      }
    }
    return resultWidgets;
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public Widget findWidgetById(Integer id) {
    for (Widget w : widgets) {
      if (id.equals(w.getId())) {
        return w;
      }
    }
    return null; // not found
  }

  public int updateWidget(String widgetId, Widget updateWidget) {
    widgetRepository.save(updateWidget);
    return 1;
  }

  public int deleteWidget(String widgetId) {
    widgets = widgets.stream()
            .filter(w -> !w.getId().equals(widgetId)).collect(Collectors.toList());
    return 1;
  }

}
