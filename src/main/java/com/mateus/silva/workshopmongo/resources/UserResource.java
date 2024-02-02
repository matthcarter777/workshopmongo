package com.mateus.silva.workshopmongo.resources;

import org.springframework.web.bind.annotation.RestController;

import com.mateus.silva.workshopmongo.domain.User;
import com.mateus.silva.workshopmongo.dto.UserDTO;
import com.mateus.silva.workshopmongo.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> list = service.findAll();

    List<UserDTO> listDto = list.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());

    return ResponseEntity.ok().body(listDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> show(@PathVariable String id) {
    User user = service.findById(id);

    return ResponseEntity.ok().body(new UserDTO(user));
  }

}
