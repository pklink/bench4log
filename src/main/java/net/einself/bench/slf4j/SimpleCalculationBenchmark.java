package net.einself.bench.slf4j;


import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class SimpleCalculationBenchmark {

    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleCalculationBenchmark.class);

    private String calc(String input) {
        return input;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void debugParam(Blackhole blackhole) {
        final var input = "input-dp";
        final var output = "output-dp";
        boolean debug = false;
        if (debug) {
            LOGGER.debug("Output of {} is {}", input, output);
        }
        blackhole.consume(input);
        blackhole.consume(output);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void classic(Blackhole blackhole) {
        final var input = "input-cl";
        final var output = "output-cl";
        LOGGER.debug("Output of {} is {}", input, output);
        blackhole.consume(input);
        blackhole.consume(output);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void supplier(Blackhole blackhole) {
        final var input = "input-su";
        final var output = "output-su";
        LOGGER.atDebug()
                .addArgument(() -> input)
                .addArgument(() -> output)
                .log("Output of {} id {}");
        blackhole.consume(input);
        blackhole.consume(output);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @Fork(1)
    public void args(Blackhole blackhole) {
        final var input = "input-su";
        final var output = "output-su";
        LOGGER.atDebug()
                .addArgument(input)
                .addArgument(output)
                .log("Output of {} id {}");
        blackhole.consume(input);
        blackhole.consume(output);
    }

}
