package com.tex.tex.Repository;

import com.tex.tex.Models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IHandleMessageRepo extends MongoRepository<Message, UUID> {

}
