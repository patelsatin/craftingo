package com.caftingo.repo;

import com.caftingo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {
    @Query("{ 'email' : ?0 }")
    User findByEmail(String email);
}
