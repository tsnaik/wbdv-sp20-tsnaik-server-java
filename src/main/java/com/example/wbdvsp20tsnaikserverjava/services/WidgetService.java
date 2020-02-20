package com.example.wbdvsp20tsnaikserverjava.services;

import com.example.wbdvsp20tsnaikserverjava.models.Widget;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class WidgetService {
  List<Widget> widgets = new ArrayList<>();

  public List<Widget> saveAllWidgets(String topicId, List<Widget> widgets) {
    removeAllWidgets(topicId);
    this.widgets.addAll(widgets);
    return widgets;
  }

  private void removeAllWidgets(String topicId) {
    widgets = widgets.stream()
            .filter(w -> !w.getTopicId().equals(topicId)).collect(Collectors.toList());
  }
  public Widget createWidget(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    widget.setId(Long.toString(new Random().nextLong()));
    widgets.add(widget);
    return widget;
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    List<Widget> resultWidgets = new ArrayList<Widget>();
    for (Widget w : widgets) {
      if (topicId.equals(w.getTopicId())) {
        resultWidgets.add(w);
      }
    }
    return resultWidgets;
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public Widget findWidgetById(String id) {
    for (Widget w : widgets) {
      if (id.equals(w.getId())) {
        return w;
      }
    }
    return null; // not found
  }

  public int updateWidget(String widgetId, Widget updateWidget) {
    for (int i = 0; i < widgets.size(); i++) {
      Widget widget = widgets.get(i);
      if (widget.getId().equals(widgetId)) {
        widgets.set(i, updateWidget);
        return 1;
      }
    }
    return 0;
  }

  public int deleteWidget(String widgetId) {
    widgets = widgets.stream()
            .filter(w -> !w.getId().equals(widgetId)).collect(Collectors.toList());
    return 1;
  }

}
