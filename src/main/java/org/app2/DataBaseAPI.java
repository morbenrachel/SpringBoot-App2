package org.app2;

import java.util.List;

public interface DataBaseAPI {
    User getUserDetailsById(String userId);
    List<User> getAllUserNames(boolean sorted);
    void addUser(User newUser);
//    void save(List<User> users);
    void saveListOfUsers(List<User> users);
}
