package org.example.java21.day4;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class CollectionsBenchmark {

    @Param({"10000", "100000", "1000000"})
    private int size;

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private ArrayDeque<Integer> arrayDeque;
    private int[] randomIndices;

    @Setup(Level.Trial)
    public void setup() {
        arrayList = new ArrayList<>(size);
        linkedList = new LinkedList<>();
        arrayDeque = new ArrayDeque<>(size);
        
        Random random = new Random(42); // Fixed seed for reproducibility
        randomIndices = new int[100_000];

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
            arrayDeque.add(i);
        }

        for (int i = 0; i < randomIndices.length; i++) {
            randomIndices[i] = random.nextInt(size);
        }
    }

    // ==========================================
    // A. INSERT AT FRONT BENCHMARKS
    // ==========================================

    @Benchmark
    public List<Integer> insertFrontArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        return list;
    }

    @Benchmark
    public List<Integer> insertFrontLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.addFirst(i);
        }
        return list;
    }

    @Benchmark
    public Deque<Integer> insertFrontArrayDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            deque.addFirst(i);
        }
        return deque;
    }

    // ==========================================
    // B. RANDOM ACCESS BENCHMARKS
    // ==========================================

    @Benchmark
    public void randomAccessArrayList(Blackhole bh) {
        for (int index : randomIndices) {
            bh.consume(arrayList.get(index));
        }
    }

    @Benchmark
    public void randomAccessLinkedList(Blackhole bh) {
        for (int index : randomIndices) {
            bh.consume(linkedList.get(index));
        }
    }

    // Note: ArrayDeque does not support indexed get(index) access.

    // ==========================================
    // C. ITERATION BENCHMARKS
    // ==========================================

    @Benchmark
    public void iterateArrayList(Blackhole bh) {
        for (Integer item : arrayList) {
            bh.consume(item);
        }
    }

    @Benchmark
    public void iterateLinkedList(Blackhole bh) {
        for (Integer item : linkedList) {
            bh.consume(item);
        }
    }

    @Benchmark
    public void iterateArrayDeque(Blackhole bh) {
        for (Integer item : arrayDeque) {
            bh.consume(item);
        }
    }

    // Main method to run the benchmark executable directly
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CollectionsBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}