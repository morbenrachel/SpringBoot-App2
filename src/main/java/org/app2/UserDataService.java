package org.app2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

//One app that acts as a user service - so every possible app that would want to actually fetch/manage the data would use its services and APIs.
//This app actually handles the data in a (basic) database - saves it, queries it, modifies it, etc.
//
//RestTemplate restTemplate = new RestTemplate();
//
//final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
//        URI uri = new URI(baseUrl);
//
//        Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");
//
//        ResponseEntity<String> result = restTemplate.postForEntity(uri, employee, String.class);


@Service
public class UserDataService implements UserDataAPI {

    RestTemplate restTemplate = new RestTemplate();

    ObjectMapper mapper = new ObjectMapper();

    final String baseUrl = "http://localhost:9090/userDataService";

    List<User> mockUserList;


    @Override
    public User getUserDetailsById(String userId) throws IOException {
        System.out.println("In getUserDetailsByUserId");
        ResponseEntity<String> response
                = restTemplate.getForEntity(baseUrl + "/getUserDetailsByUserId/"+userId, String.class);
//        Assert.assertEquals(200, response.getStatusCodeValue());
//        assertThat(response.getStatusCode(),
//                equalTo(HttpStatus.OK));

        JsonNode root = mapper.readTree(response.getBody());

        User test = new User("bla", "bla", 1234, "23948434848494");
        return test;
    }

    @Override
    public List<User> getAllUserNames(boolean sorted) throws IOException {
        ResponseEntity<String> response
                = restTemplate.getForEntity(baseUrl + "/getAllUserNames/"+sorted, String.class);
        JsonNode root = mapper.readTree(response.getBody());
        return mockUserList;
    }

    @Override
    public String addUser(String name, String surname, int birthYear) {
        // generate UUID for user
        String newUserUUID = UUID.randomUUID().toString();
        User newUser = new User(name, surname, birthYear, newUserUUID);
        ResponseEntity<String> result = restTemplate.postForEntity(baseUrl + "addUser/{newUser}", newUser, String.class);
        System.out.println("add user = " + result);
        return newUserUUID;
    }

}
