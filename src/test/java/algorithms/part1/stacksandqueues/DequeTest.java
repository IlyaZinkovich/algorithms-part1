package algorithms.part1.stacksandqueues;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import algorithms.part1.stacksandqueues.assignment.Deque;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class DequeTest {

  @Test
  void test() {
    final Deque<Integer> deque = new Deque<>();
    IntStream.range(0, 4).forEach(deque::addFirst);
    IntStream.range(0, 4).forEach(deque::addLast);
    IntStream.range(0, 4).forEach(i -> assertEquals(deque.removeFirst(), deque.removeLast()));
    assertTrue(deque.isEmpty());
    IntStream.range(0, 4).forEach(deque::addFirst);
    IntStream.range(0, 4).forEach(deque::addLast);
    assertEquals(8, deque.size());
    IntStream.range(0, 6).forEach(i -> deque.removeFirst());
    IntStream.range(0, 2).forEach(i -> deque.removeLast());
    assertTrue(deque.isEmpty());
    final Set<Integer> ints = IntStream.range(0, 8).peek(deque::addFirst).boxed().collect(toSet());
    assertEquals(8, deque.size());
    for (Integer i : deque) {
      ints.remove(i);
    }
    assertTrue(ints.isEmpty());
  }
}
