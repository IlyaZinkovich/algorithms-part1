package algorithms.part1.stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Random;
import org.junit.jupiter.api.Test;

class MaxStackTest {

  @Test
  void test() {
    final MaxStack<Integer> maxStack =
        new MaxStack<>(new ArrayStack<>(), Comparator.comparingInt(left -> left));
    final OptionalInt maxInt = new Random().ints().peek(maxStack::push).limit(10).max();
    assertEquals(maxInt.getAsInt(), maxStack.max());
  }
}
