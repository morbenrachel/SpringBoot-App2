package org.app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class App2Controller {
    @Autowired
    private DataBaseService dbService;


    @GetMapping("userDataService/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") String userId) {
        //should communicate via http to the userDataService and not access its methods directly
        User gotUser = dbService.getUserDetailsById(userId);
        ResponseEntity <User> userRes = new ResponseEntity<User>(gotUser, HttpStatus.OK);
        return userRes;
    }

    @GetMapping("userDataService/getAllUsers/{sorted}")
    public ResponseEntity<List <User>>  getUsers(@PathVariable("sorted") Boolean sorted) {
        List<User> allUsers = dbService.getAllUserNames(sorted);
        ResponseEntity <List<User>> allUsersRes = new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
        return allUsersRes;
    }

    @PostMapping("userDataService/addUser")
    public ResponseEntity<String> create(@RequestBody Map<String, String> body){
        int birthYear = Integer.parseInt(body.get("birthYear"));
        String name = body.get("name");
        String surname = body.get("surname");
        String newUserUUID = UUID.randomUUID().toString();
        User newUser = new User(name, surname, birthYear, newUserUUID);
        dbService.addUser(newUser);
        ResponseEntity <String> newUserUUIDRes = new ResponseEntity<String>(newUserUUID, HttpStatus.OK);
        return newUserUUIDRes;
    }

}
