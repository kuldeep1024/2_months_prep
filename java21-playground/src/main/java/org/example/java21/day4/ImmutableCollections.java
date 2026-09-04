package org.example.java21.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableCollections {
    static void main(String[] args) {
        //Creates an immutable list.
        List<String> list = List.of("A", "B", "C");
        //list.add("D");       // UnsupportedOperationException
        // list.set(0, "X");    // UnsupportedOperationException

        //It also rejects null:
        //list.add(null);  // NullPointerException

        //Use it when you are creating the list yourself and want it immutable.


        List<String> original = new ArrayList<>();
        original.add("A");

        //view is an unmodifiable view, not an immutable copy.
        List<String> view = Collections.unmodifiableList(original);

        //view.add("B");       // UnsupportedOperationException
        original.add("B");

        System.out.println(view);  // [A, B]
        //The original list can still change, and those changes are visible through the unmodifiable view.

        List<String> originalList = new ArrayList<>();
        originalList.add("A");

        //Creates an immutable snapshot.
        List<String> copy = List.copyOf(originalList);

        original.add("B");

        System.out.println(original); // [A, B]
        System.out.println(copy);     // [A]

        //Use it when you're receiving a mutable collection but want to defensively copy it into an immutable list.

    }
}
