package org.example.java21.day2;

import java.util.Locale;
import java.lang.Record;

public record User(String name, String email, String role) {

    // We can Override Record Methods
    @Override
    public String name() {
        return this.name.toLowerCase();
    }

    //We can also add our own methods
    public boolean isCorporateUser() {
        return email.endsWith("@corporate.com");
    }

    //Canonical Constructor
    /*public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    */

    //Compact Constructor
    public User {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    //Static Factory Methods on Records
    public static User adminRole(String name, String email) {
        return new User(name, email, "ADMIN");
    }

    //User.adminRole("kk","kk@gamil.com");

    //Records can also be generic.
    public record Pair<T>(T first, T second) {
    }

    //Pair<String> names = new Pair<>("John", "David");
    //Pair<Integer> numbers = new Pair<>(10, 20);
}