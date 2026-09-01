package org.example.java21.day1.var;

public class VarWorseReadability {
    public static void main(String[] args) {
        // Bad: What is the return type or factory method type here? 
        // It's completely non-obvious without hovering over or reading documentation.
        var data = RepositoryManager.loadConfiguration();
        
        System.out.println("Loaded config: " + data);
    }
    
    static class RepositoryManager {
        static Object loadConfiguration() { return "ConfigData"; }
    }
}