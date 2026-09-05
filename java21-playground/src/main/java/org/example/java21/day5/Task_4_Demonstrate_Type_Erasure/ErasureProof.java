package org.example.java21.day5.Task_4_Demonstrate_Type_Erasure;

import java.util.ArrayList;
import java.util.List;

public class ErasureProof {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        Class<?> class1 = stringList.getClass();
        Class<?> class2 = integerList.getClass();

        System.out.println("List<String> class:  " + class1.getName());
        System.out.println("List<Integer> class: " + class2.getName());
        System.out.println("Are classes equal?   " + (class1 == class2));
    }
}