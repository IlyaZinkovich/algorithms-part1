package algorithms.part1.stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class TwoStackQueueTest {

  @Test
  void test() {
    final Queue<Integer> queue = new TwoStackQueue<>(new ArrayStack<>(), new ArrayStack<>());
    final int n = 3;
    final int[] original = IntStream.range(0, n).peek(queue::enqueue).toArray();
    final int[] fromQueue = IntStream.generate(queue::dequeue).limit(n).toArray();
    assertArrayEquals(original, fromQueue);
  }
}
