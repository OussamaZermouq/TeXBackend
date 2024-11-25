package com.tex.tex.Repository;

import com.tex.tex.Models.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;

public interface IHandleProfileRepo extends MongoRepository<Profile, UUID> {
    @Query("{'username':?0}")
    public Profile getProfileByUsername(String username);

    @Query("{'profileId': ?0}")
    public Profile getProfileById(UUID uuid);

}
