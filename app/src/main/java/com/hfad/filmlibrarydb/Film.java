package com.hfad.filmlibrarydb;

public class Film {

  protected String name;
  protected String description;

  protected Film(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return name;
//    return  name + " " + description;
  }
}
