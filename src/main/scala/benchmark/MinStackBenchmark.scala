package benchmark

import example.minstack.{MinStack, MinStackArrayDeque, MinStackLinkedBlockingDeque}
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Mode, OutputTimeUnit}

import java.util.concurrent.TimeUnit
import scala.util.Random

@OutputTimeUnit(TimeUnit.MINUTES)
@BenchmarkMode(Array(Mode.Throughput))
class MinStackBenchmark {

  @Benchmark
  def arrayDeque(): Unit = doThings(new MinStackArrayDeque)

  @Benchmark
  def linkedBlockingDeque(): Unit = doThings(new MinStackLinkedBlockingDeque)

  def doThings(minStack: MinStack): Unit = {
    (1 to 2000000).foreach(iteration => {
      minStack.push(Random.between(-1000000, 1000000))
      if (iteration % 7 == 0) {
        minStack.getMin()
      }
      if (iteration % 5 == 0) {
        minStack.pop()
      }
    })
  }

}
