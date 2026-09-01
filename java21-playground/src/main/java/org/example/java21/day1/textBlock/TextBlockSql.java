package org.example.java21.day1.textBlock;

public class TextBlockSql {
    public static void main(String[] args) {
        String query = """
                SELECT id, first_name, last_name
                FROM users
                WHERE status = 'ACTIVE'
                  AND created_at >= '2026-01-01'
                ORDER BY last_name ASC;
                """;
        System.out.println(query);
    }
}