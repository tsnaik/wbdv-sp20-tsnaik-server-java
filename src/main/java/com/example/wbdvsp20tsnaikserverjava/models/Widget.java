package com.example.wbdvsp20tsnaikserverjava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "widgets")
public class Widget {
  @JsonProperty("_id")
  @Id
  private String id;
  private String name;
  private String type;
  private String ordering;
  private String text;
  private String paragraphText;
  private String url;
  private Integer size;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;
  private String topicId;

  @Override
  public String toString() {
    return "Widget{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", order='" + ordering + '\'' +
            ", text='" + text + '\'' +
            ", paragraphText='" + paragraphText + '\'' +
            ", url='" + url + '\'' +
            ", size=" + size +
            ", width=" + width +
            ", height=" + height +
            ", cssClass='" + cssClass + '\'' +
            ", style='" + style + '\'' +
            ", value='" + value + '\'' +
            ", topicId='" + topicId + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getOrdering() {
    return ordering;
  }

  public void setOrdering(String ordering) {
    this.ordering = ordering;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public String getParagraphText() {
    return paragraphText;
  }

  public void setParagraphText(String paragraphText) {
    this.paragraphText = paragraphText;
  }
}
