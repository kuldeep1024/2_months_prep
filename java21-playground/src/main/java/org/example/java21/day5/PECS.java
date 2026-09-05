package org.example.java21.day5;

import java.util.ArrayList;
import java.util.List;

public class PECS {
    static void printAnimals(List<? extends Animal> animals) {
        // We can READ from the list
        for (Animal animal : animals) {
            System.out.println(animal.name);
            animal.eat();
        }

        // We CANNOT safely add an Animal
        // animals.add(new Dog("Buddy"));  // ❌
        // animals.add(new Cat("Kitty"));  // ❌
    }

    static void addDogs(List<? super Dog> animals) {
        // We can WRITE Dogs into the list
        animals.add(new Dog("Buddy"));
        animals.add(new Dog("Max"));

        // But when reading, we only know it's Object
        Object animal = animals.get(0);

        System.out.println(animal);
    }

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();

        dogs.add(new Dog("Rocky"));
        dogs.add(new Dog("Bruno"));

        List<Cat> cats = new ArrayList<>();

        cats.add(new Cat("Kitty"));
        cats.add(new Cat("Luna"));

        System.out.println("DOGS:");

        printAnimals(dogs);

        System.out.println("\nCATS:");

        printAnimals(cats);

        List<Animal> animals = new ArrayList<>();

        addDogs(animals);

        System.out.println("\nAnimals:");

        for (Animal animal : animals) {
            animal.eat();
        }
    }
}

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    void bark() {
        System.out.println(name + " says Woof!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    void meow() {
        System.out.println(name + " says Meow!");
    }
}