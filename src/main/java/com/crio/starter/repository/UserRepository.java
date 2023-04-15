package com.crio.starter.repository;

import com.crio.starter.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public boolean existsByUsername(String username);
}
