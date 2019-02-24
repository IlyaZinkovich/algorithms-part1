package algorithms.part1.stacksandqueues;

public class ArrayStack<Item> implements Stack<Item> {

  private int capacity;
  private int current;
  private Item[] items;

  public ArrayStack() {
    this.capacity = 1;
    this.current = 0;
    this.items = (Item[]) new Object[capacity];
  }

  public void push(Item item) {
    if (capacity == current) {
      resize(capacity * 2);
    }
    items[current] = item;
    current++;
  }

  public Item pop() {
    final Item item = items[current - 1];
    items[current - 1] = null;
    current--;
    if (current > 0 && current == capacity / 4) {
      resize(capacity / 4);
    }
    return item;
  }

  @Override
  public boolean isEmpty() {
    return current == 0;
  }

  private void resize(final int size) {
    Item[] buffer = (Item[]) new Object[size];
    for (int i = 0; i < Math.min(size, capacity); i++) {
      buffer[i] = items[i];
      items[i] = null;
    }
    capacity = size;
    items = buffer;
  }
}
