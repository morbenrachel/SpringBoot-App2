package org.app2;

import java.io.IOException;
import java.util.List;

public interface UserDataAPI {
    User getUserDetailsById(String userId) throws IOException;
    List<User> getAllUserNames(boolean sorted) throws IOException;
    String addUser(String name, String surname, int birthYear);
}
