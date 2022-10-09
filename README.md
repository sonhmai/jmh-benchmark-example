
JMH Benchmark Example in Scala 

* using JMH to benchmark different data structures selection for implementing a Min Stack
* in Scala and sbt using sbt-jmh plugin

## Benchmarking

```shell
sbt
jmh:run -i 20 -wi 10 -f1 -t1
```

* -i 20 says that we want to run each benchmark with 20 iterations
* -wi 10 says to run 10 warmup iterations
* -f 10 says to fork once on each benchmark
* -t1 says to run on one thread

Result example: throughput `arrayDeque` 457 ops/min, `linkedBlockingDeque` 221 ops/min.
This is likely because one is a concurrent data structure using lock and the other is not.
```shell
[info] # Run complete. Total time: 00:10:11
[info] REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
[info] why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
[info] experiments, perform baseline and negative tests that provide experimental control, make sure
[info] the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
[info] Do not assume the numbers tell you what you want them to tell.
[info] Benchmark                               Mode  Cnt    Score   Error    Units
[info] MinStackBenchmark.arrayDeque           thrpt   20  457.900 ± 5.128  ops/min
[info] MinStackBenchmark.linkedBlockingDeque  thrpt   20  221.289 ± 7.889  ops/min
```