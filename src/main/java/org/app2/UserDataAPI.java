package org.app2;

import java.util.List;
import java.util.UUID;

public interface UserDataAPI {
    User getUserDetailsByUserId(UUID userId);
    List<String> getAllUserNames(boolean sorted);
    UUID addUser(String name, String surname, int birthYear);
    void save(List<User> users);
}
