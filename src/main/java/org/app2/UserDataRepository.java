package org.app2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserDataRepository extends MongoRepository<User, String> {
    @Query(value="{}", fields="{ 'userId': 0}")
    List<User> getAllUserNames();
    public User findByUserId(String userId);
    public void save(List<User> users);
}