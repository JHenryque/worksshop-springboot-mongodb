package org.projeto.mongodb.services;

import org.projeto.mongodb.domain.Post;
import org.projeto.mongodb.domain.User;
import org.projeto.mongodb.dto.UserDTO;
import org.projeto.mongodb.exception.ObjetNotFoundException;
import org.projeto.mongodb.repository.PostRepository;
import org.projeto.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjetNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String nome) {
        return repository.searchTitle(nome);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }

}
