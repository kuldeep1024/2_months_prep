package org.example.java21.day5.task_1_string_benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
public class StringBenchmark {

    @Param({"10", "1000", "100000"})
    public int iterations;

    @Benchmark
    public String stringConcatenation() {
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a";
        }
        return str;
    }

    @Benchmark
    public String stringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        return sb.toString();
    }

    // Main method to run the benchmark executable directly
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}