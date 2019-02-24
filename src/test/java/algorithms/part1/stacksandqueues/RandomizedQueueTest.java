package algorithms.part1.stacksandqueues;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import algorithms.part1.stacksandqueues.assignment.RandomizedQueue;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class RandomizedQueueTest {

  @Test
  void test() {
    final RandomizedQueue<Integer> queue = new RandomizedQueue<>();
    assertTrue(queue.isEmpty());
    queue.enqueue(1);
    assertEquals(1, queue.dequeue());
    final Set<Integer> ints = IntStream.range(0, 10).peek(queue::enqueue).boxed().collect(toSet());
    final Set<Integer> randomInts = IntStream.generate(queue::dequeue).limit(10).boxed()
        .collect(toSet());
    assertEquals(ints, randomInts);
    IntStream.range(0, 10).forEach(queue::enqueue);
    final List<Integer> reorderedInts = IntStream.generate(queue::dequeue).limit(10).boxed()
        .collect(toList());
    assertTrue(reorderedInts.containsAll(ints));
  }
}
