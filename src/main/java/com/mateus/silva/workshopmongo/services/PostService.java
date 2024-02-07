package com.mateus.silva.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.silva.workshopmongo.domain.Post;
import com.mateus.silva.workshopmongo.domain.User;
import com.mateus.silva.workshopmongo.dto.UserDTO;
import com.mateus.silva.workshopmongo.repository.PostRepository;
import com.mateus.silva.workshopmongo.repository.UserRepository;
import com.mateus.silva.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

  @Autowired
  private PostRepository repo;

  public Post findById(String id) {
    Optional<Post> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

}
