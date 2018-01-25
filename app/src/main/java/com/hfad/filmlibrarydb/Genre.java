package com.hfad.filmlibrarydb;

public class Genre extends BaseActivity{

  protected String name;
  protected String description;

//  static Genre[] genres = {
//
////      new Genre("Боевик", "Боевики"),
////      new Genre("Вестерн", "Вестерны"),
////      new Genre("Детектив", "Детективы"),
////      new Genre("Детское кино", "Детское кино"),
////      new Genre("Документальное кино", "Документальное кино"),
////      new Genre("Драма", "Драмы"),
////      new Genre("Комедия", "Комедии"),
////      new Genre("Приключение", "Приключения"),
////      new Genre("Семейное кино", "Семейное кино"),
////      new Genre("Триллер", "Триллеры"),
////      new Genre("Ужасы", "Ужасы"),
////      new Genre("Фантастика", "Фантастика")
//  };

  protected Genre(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }

}
