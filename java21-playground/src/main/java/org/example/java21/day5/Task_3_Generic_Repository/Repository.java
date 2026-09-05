package org.example.java21.day5.Task_3_Generic_Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Repository<T extends Entity> {

    private final List<T> storage = new ArrayList<>();

    public void add(T entity) {
        storage.add(entity);
    }

    // Producer Extends: Accepts Collections of T or any subtype of T
    public void addAll(Collection<? extends T> source) {
        storage.addAll(source);
    }

    // Consumer Super: Copies elements into a Collection of T or any supertype of T
    public void copyTo(Collection<? super T> destination) {
        destination.addAll(storage);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(storage);
    }
}