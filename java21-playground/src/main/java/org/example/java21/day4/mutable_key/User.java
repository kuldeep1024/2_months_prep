package org.example.java21.day4.mutable_key;

public class User {
    String email;
    String name;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (email == null) {
            if (user.email != null) return false;
        } else if (!email.equals(user.email)) {
            return false;
        }

        if (name == null) {
            return user.name == null;
        } else if (!name.equals(user.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + (email == null ? 0 : email.hashCode());
        result = 31 * result + (name == null ? 0 : name.hashCode());

        return result;
    }
}