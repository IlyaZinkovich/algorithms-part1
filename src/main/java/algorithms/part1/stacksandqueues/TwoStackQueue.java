package algorithms.part1.stacksandqueues;

public class TwoStackQueue<Item> implements Queue<Item> {

  private final Stack<Item> left;
  private final Stack<Item> right;

  public TwoStackQueue(
      final Stack<Item> left,
      final Stack<Item> right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public void enqueue(final Item item) {
    left.push(item);
  }

  @Override
  public Item dequeue() {
    if (!right.isEmpty()) {
      return right.pop();
    } else {
      while (!left.isEmpty()) {
        right.push(left.pop());
      }
      return right.pop();
    }
  }

  @Override
  public boolean isEmpty() {
    return left.isEmpty() && right.isEmpty();
  }
}
