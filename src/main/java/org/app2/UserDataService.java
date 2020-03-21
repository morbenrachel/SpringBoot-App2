package org.app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//One app that acts as a user service - so every possible app that would want to actually fetch/manage the data would use its services and APIs.
//This app actually handles the data in a (basic) database - saves it, queries it, modifies it, etc.


@Service
public class UserDataService implements UserDataAPI {
    @Autowired
    private UserDataRepository repository;

    @Override
    public User getUserDetailsByUserId(UUID userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<String> getAllUserNames(boolean sorted) {
//        Query query = new Query();
        if (sorted) {
            return repository.getAllByFirstNameOrderByBirthYear();
//            query.with(new Sort(Sort.Direction.ASC, "birthYear"));
        }
        return repository.getAllByFirstName();
//        query.fields().include("name");
//        return mongoTemplate.find(query, User.class);
//        return repository.findAllUserNames(query);

    }

    @Override
    public UUID addUser(String name, String surname, int birthYear) {
        // generate UUID for user
        UUID newUserUUID = UUID.randomUUID();
        User newUser = new User(name, surname, birthYear, newUserUUID);
        repository.save(newUser);
        return newUserUUID;
    }

    @Override
    public void save(List<User> users) {
        users.forEach((user) -> repository.save(user) );
    }
}
