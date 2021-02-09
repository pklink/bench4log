package net.einself.bench.slf4j;


import de.mkammerer.argon2.Argon2Factory;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ComplexCalculationBenchmark {

    private final static Logger LOGGER = LoggerFactory.getLogger(ComplexCalculationBenchmark.class);

    private String calc(String input) {
        final var argon2 = Argon2Factory.create();
        return argon2.hash(2, 16, 1, input.getBytes());
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void debugParam(Blackhole blackhole) {
        final var input = "secret-dp";
        boolean debug = false;
        if (debug) {
            LOGGER.debug("Scrypt of {}: {}", input, calc(input));
        }
        blackhole.consume(input);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void classic(Blackhole blackhole) {
        final var input = "secret-cl";
        LOGGER.debug("Scrypt of {}: {}", input, calc(input));
        blackhole.consume(input);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void supplier(Blackhole blackhole) {
        final var input = "secret-su";
        LOGGER.atDebug()
                .addArgument(input)
                .addArgument(() -> calc(input))
                .log("Scrypt of {}: {}");
        blackhole.consume(input);
    }


}
