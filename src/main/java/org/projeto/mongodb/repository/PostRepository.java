package org.projeto.mongodb.repository;

import org.projeto.mongodb.domain.Post;
import org.projeto.mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
