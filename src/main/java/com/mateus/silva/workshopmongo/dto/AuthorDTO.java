package com.mateus.silva.workshopmongo.dto;

import java.io.Serializable;

import com.mateus.silva.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private String id;
  private String name;

  public AuthorDTO() {
  }

  public AuthorDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
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

}
