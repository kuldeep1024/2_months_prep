package org.example.java21.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TeeingExample {
    static void main(String[] args) {
        //teeing() lets you send the same stream into two collectors and combine their results.

        List<Employee> employees = Arrays.asList(
                new Employee("HR", 50000),
                new Employee("IT", 60000),
                new Employee("Finance", 55000),
                new Employee("IT", 65000),
                new Employee("Finance", 85000),
                new Employee("Finance", 55000));

        var result = employees.stream()
                .collect(
                        teeing(
                                counting(),
                                averagingDouble(Employee::salary),
                                (count, avg) -> new Summary(count, avg)
                        )
                );

        System.out.println(result);

        //department → count + average salary
        Map<String, Summary> map = employees.stream()
                .collect(
                        groupingBy(
                                Employee::department,
                                teeing(
                                        counting(),
                                        averagingDouble(Employee::salary),
                                        Summary::new
                                ))
                );
        map.entrySet().stream().forEach(System.out::println);
    }
}

record Employee(String department, double salary) {
}

record Summary(Long count, Double average) {
}