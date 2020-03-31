package org.app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseService implements DataBaseAPI {
    @Autowired
    private UserDataRepository repository;

    @Override
    public User getUserDetailsById(String userId) {
        System.out.println("In getUserDetailsByUserId");
        User userDetails = repository.findByUserId(userId);
        System.out.println("birthyear received = " + userDetails.birthYear);
        return repository.findByUserId(userId);
    }

    @Override
    public List<User> getAllUserNames(boolean sorted) {
        System.out.println("In dbService getAllUserName, sorted = " + sorted);
        if (sorted) {
            System.out.println("findnAllByOrderByBirthYear");
            return repository.findAll(new Sort(Sort.Direction.ASC, "BirthYear"));
        }
        System.out.println("getAllUserNames");
        return repository.getAllUserNames();
    }

    @Override
    public void addUser(User newUser) {
        repository.save(newUser);
    }

    @Override
    public void saveListOfUsers(List<User> users) {
        users.forEach((user) -> repository.save(user) );
    }

}
