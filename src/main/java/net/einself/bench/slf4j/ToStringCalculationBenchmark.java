package net.einself.bench.slf4j;


import net.einself.bench.slf4j.domain.Dog;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ToStringCalculationBenchmark {

    private final static Logger LOGGER = LoggerFactory.getLogger(ToStringCalculationBenchmark.class);

    private String calc(String input) {
        return input;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void debugParam(Blackhole blackhole) {
        final var dog = new Dog(1L, "Poodle", "Bernie");
        boolean debug = false;
        if (debug) {
            LOGGER.debug("Output of {}", dog.toString());
        }
        blackhole.consume(dog);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void classic(Blackhole blackhole) {
        final var dog = new Dog(2L, "Labrado Retriever", "Mr. Peanutbutter");
        LOGGER.debug("Output of {}", dog.toString());
        blackhole.consume(dog);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void supplier(Blackhole blackhole) {
        final var dog = new Dog(3L, "Greyhound", "Knecht Ruprecht");
        LOGGER.atDebug()
                .addArgument(dog::toString)
                .log("Output of {}");
        blackhole.consume(dog);
    }


}
