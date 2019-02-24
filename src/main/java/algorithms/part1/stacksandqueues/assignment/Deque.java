package algorithms.part1.stacksandqueues.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

  private Node<Item> first;
  private Node<Item> last;
  private int size = 0;

  public Deque() {
  }

  public boolean isEmpty() {
    return first == null && last == null;
  }

  public int size() {
    return size;
  }

  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    } else if (isEmpty()) {
      first = new Node<>(item);
      last = first;
      size++;
    } else {
      Node<Item> newFirstElement = new Node<>(item);
      newFirstElement.next = first;
      first.previous = newFirstElement;
      first = newFirstElement;
      size++;
    }
  }

  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    } else if (isEmpty()) {
      last = new Node<>(item);
      first = last;
      size++;
    } else {
      Node<Item> newLastElement = new Node<>(item);
      newLastElement.previous = last;
      last.next = newLastElement;
      last = newLastElement;
      size++;
    }
  }

  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else if (size == 1) {
      Item result = first.item;
      first = null;
      last = null;
      size--;
      return result;
    } else {
      Item result = first.item;
      first = first.next;
      if (first != null) {
        first.previous = null;
      } else {
        last = null;
      }
      size--;
      return result;
    }
  }

  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else if (size == 1) {
      Item result = last.item;
      first = null;
      last = null;
      size--;
      return result;
    } else {
      Item result = last.item;
      last = last.previous;
      if (last != null) {
        last.next = null;
      } else {
        first = null;
      }
      size--;
      return result;
    }
  }

  public Iterator<Item> iterator() {
    return new DequeIterator(first);
  }

  private static class Node<Item> {

    public final Item item;
    public Node<Item> next;
    public Node<Item> previous;

    private Node(final Item item) {
      this.item = item;
    }
  }

  private class DequeIterator implements Iterator<Item> {

    private Node<Item> current;

    private DequeIterator(final Node<Item> current) {
      this.current = current;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      } else {
        final Item item = current.item;
        current = current.next;
        return item;
      }
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
