package org.example.java21.day2;

interface Identifiable {
    String id();
}

record IdentifiableUser(String id, String name) implements Identifiable {
}

record IdentifiableUser2(String id1, String name) implements Identifiable {
    @Override
    public String id() {
        return "";
    }
}