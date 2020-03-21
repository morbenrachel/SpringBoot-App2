package org.app2;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class User {

    @Id
    public UUID userId;

    public String firstName;
    public String lastName;
    public int birthYear;

    public User() {}

    public User(String firstName, String lastName, int birthYear, UUID userUUID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.userId = userUUID;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s']",
                userId, firstName, lastName);
    }

}