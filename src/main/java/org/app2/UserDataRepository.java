package org.app2;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface UserDataRepository extends MongoRepository<User, String> {
    public User findByUserId(UUID userId);
    public List<String> getAllByFirstNameOrderByBirthYear();
    public List<String> getAllByFirstName();
    public void save(List<User> users);
}