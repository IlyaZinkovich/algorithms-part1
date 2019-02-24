package algorithms.part1.stacksandqueues.assignment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

  public static void main(String[] args) {
    final RandomizedQueue<String> queue = new RandomizedQueue<>();
    int k = Integer.parseInt(args[0]);
    while (!StdIn.isEmpty()) {
      final String string = StdIn.readString();
      queue.enqueue(string);
    }
    for (int i = 0; i < k; i++) {
      StdOut.println(queue.dequeue());
    }
  }
}
