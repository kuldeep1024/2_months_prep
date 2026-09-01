package org.example.java21.day1.var;

import java.time.LocalDate;
import java.util.HashMap;

public class NormalUsefulVar {
    public static void main(String[] args) {
        var today = LocalDate.now();
        var userSessions = new HashMap<String, Integer>();
        
        userSessions.put("alice", 3);
        
        System.out.println("Date: " + today);
        System.out.println("Sessions for alice: " + userSessions.get("alice"));
    }
}