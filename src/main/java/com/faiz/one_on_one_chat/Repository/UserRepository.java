package com.faiz.one_on_one_chat.Repository;

import com.faiz.one_on_one_chat.Model.Status;
import com.faiz.one_on_one_chat.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
