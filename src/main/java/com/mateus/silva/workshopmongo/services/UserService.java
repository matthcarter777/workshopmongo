package com.mateus.silva.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.silva.workshopmongo.domain.User;
import com.mateus.silva.workshopmongo.dto.UserDTO;
import com.mateus.silva.workshopmongo.repository.UserRepository;
import com.mateus.silva.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  public List<User> findAll() {
    return repo.findAll();
  }

  public User findById(String id) {
    Optional<User> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

  public User insert(User user) {
    return repo.insert(user);
  }

  public User fromDTO(UserDTO objDto) {
    return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
  }

}
