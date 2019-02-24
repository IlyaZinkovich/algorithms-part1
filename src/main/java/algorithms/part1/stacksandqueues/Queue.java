package algorithms.part1.stacksandqueues;

public interface Queue<Item> {

  void enqueue(Item item);

  Item dequeue();

  boolean isEmpty();
}
