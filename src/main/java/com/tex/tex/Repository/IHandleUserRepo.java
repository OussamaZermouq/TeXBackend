package com.tex.tex.Repository;

import com.tex.tex.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IHandleUserRepo extends MongoRepository<User, UUID> {
    @Query("{ 'email': ?0 }")
    public User findByEmail(String email);

}
