package algorithms.part1.unionfind.assignment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

public class PercolationTest {

  @Test
  void test() {
    final int n = 20;
    final Percolation percolation = new Percolation(n);
    boolean percolates = false;
    while (!percolates) {
      final int number = StdRandom.uniform(1, n * n + 1);
      percolation.open((int) Math.ceil((double) number / n), number % n + 1);
      percolates = percolation.percolates();
    }
    assertTrue(percolation.percolates());
    System.out.println(percolation.numberOfOpenSites());
  }
}
