# BENCH4LOG

Based on Java JMH

## Results

Setup
* adopt-openjdk-11 11.0.10
* Windows 10
* AMD Ryzen 5 2600x Six-Core Processor
* 32 GB memory 
* SSD

### SimpleCalculationBenchmark 

Full log in `full-SimpleCalculationBenchmark.log`

```
Benchmark                               Mode  Cnt       Score     Error   Units
SimpleCalculationBenchmark.args        thrpt   10  104776,328 ± 587,974  ops/ms
SimpleCalculationBenchmark.classic     thrpt   10  105277,430 ± 364,335  ops/ms
SimpleCalculationBenchmark.debugParam  thrpt   10  114456,739 ± 319,276  ops/ms
SimpleCalculationBenchmark.supplier    thrpt   10  105132,528 ± 452,660  ops/ms
```

### ToStringCalculationBenchmark

Full log in `full-SimpleCalculationBenchmark.log`

```
Benchmark                                 Mode  Cnt       Score      Error   Units
ToStringCalculationBenchmark.classic     thrpt   10   20427,858 ±  214,218  ops/ms
ToStringCalculationBenchmark.debugParam  thrpt   10  138947,695 ± 1099,763  ops/ms
ToStringCalculationBenchmark.supplier    thrpt   10  136209,422 ± 3000,889  ops/ms
```

### ComplexCalculationBenchmark

Full log in `full-ComplexCalculationBenchmark.log`

```
Benchmark                                Mode  Cnt       Score      Error   Units
ComplexCalculationBenchmark.classic     thrpt   10      15,289 ±    0,454  ops/ms
ComplexCalculationBenchmark.debugParam  thrpt   10  222770,464 ± 1287,953  ops/ms
ComplexCalculationBenchmark.supplier    thrpt   10  186248,062 ± 1242,702  ops/ms
```
