package algorithms.part1.stacksandqueues.assignment;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

  private Item[] items;
  private int size;
  private int capacity;

  public RandomizedQueue() {
    this.size = 0;
    this.capacity = 1;
    this.items = (Item[]) new Object[capacity];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    } else {
      if (capacity == size) {
        resize(capacity * 2);
      }
      items[size] = item;
      size++;
    }
  }

  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      if (size > 0 && size == capacity / 4) {
        resize(capacity / 4);
      }
      int index = StdRandom.uniform(0, size);
      Item result = items[index];
      size--;
      items[index] = items[size];
      return result;
    }
  }

  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return items[StdRandom.uniform(0, size)];
  }

  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
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

  private class RandomizedQueueIterator implements Iterator<Item> {

    private final Item[] array;
    private int current;

    private RandomizedQueueIterator() {
      Item[] copy = (Item[]) new Object[size];
      System.arraycopy(items, 0, copy, 0, size);
      for (int i = 0; i < size; i++) {
        int from = StdRandom.uniform(0, size);
        int to = StdRandom.uniform(0, size);
        Item temp = copy[from];
        copy[from] = copy[to];
        copy[to] = temp;
      }
      this.array = copy;
      this.current = 0;
    }

    @Override
    public boolean hasNext() {
      return current < array.length;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Item item = array[current];
      current++;
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
