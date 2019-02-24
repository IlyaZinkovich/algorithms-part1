package algorithms.part1.stacksandqueues;

import java.util.Comparator;

public class MaxStack<Item> implements Stack<Item> {

  private final Stack<Item> stack;
  private final Comparator<Item> itemComparator;
  private Item max;

  public MaxStack(final Stack<Item> stack,
      final Comparator<Item> itemComparator) {
    this.stack = stack;
    this.itemComparator = itemComparator;
  }

  @Override
  public void push(final Item item) {
    stack.push(item);
    if (max == null || itemComparator.compare(max, item) < 0) {
      max = item;
    }
  }

  @Override
  public Item pop() {
    return stack.pop();
  }

  @Override
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public Item max() {
    return max;
  }
}
