package com.example.wbdvsp20tsnaikserverjava.controllers;

import com.example.wbdvsp20tsnaikserverjava.models.Widget;
import com.example.wbdvsp20tsnaikserverjava.services.WidgetService;

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
public class WidgetController {

  @Autowired
  WidgetService service;

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidget(@PathVariable("tid") Integer tid, @RequestBody Widget widget) {
    return service.createWidget(tid, widget);
  }

  @PutMapping("/api/topics/{tid}/widgets")
  public List<Widget> saveAllWidgets(@PathVariable("tid") Integer tid,
                                     @RequestBody List<Widget> widgets) {
    return service.saveAllWidgets(tid, widgets);
  }

  @PutMapping("/api/widgets/{wid}")
  public int updateWidget(@PathVariable("wid") Integer wid, @RequestBody Widget widget) {
    return service.updateWidget(wid, widget);
  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public int deleteWidget(@PathVariable("widgetId") Integer wid) {
    return service.deleteWidget(wid);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
    return service.findWidgetById(wid);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(
          @PathVariable("tid") Integer topicId) {
    return service.findWidgetsForTopic(topicId);
  }
}
