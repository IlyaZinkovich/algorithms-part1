package algorithms.part1.stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  void test() {
    final Stack<Integer> stack = new ArrayStack<>();
    final int n = 3;
    final int[] original = IntStream.range(0, n).peek(stack::push).toArray();
    final int[] reversed = IntStream.generate(stack::pop).limit(n).toArray();
    IntStream.range(0, n).forEach(i -> assertEquals(original[i], reversed[n - i - 1]));
  }
}
