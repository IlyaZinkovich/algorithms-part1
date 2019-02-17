package algorithms.part1.unionfind.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private final boolean[] openedSites;
  private final int n;
  private final WeightedQuickUnionUF quickUnionUF;
  private int numberOfOpenedSites;
  private final int topNode;
  private final int bottomNode;

  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }
    this.openedSites = new boolean[n * n + 1];
    this.n = n;
    this.quickUnionUF = new WeightedQuickUnionUF(n * n + 3);
    this.numberOfOpenedSites = 0;
    this.topNode = n * n + 1;
    this.bottomNode = n * n + 2;
  }

  public void open(int row, int col) {
    validateRowAndCol(row, col);
    if (!isOpen(row, col)) {
      if (row > 1 && isOpen(row - 1, col)) {
        quickUnionUF.union(toArrayIndex(row, col), toArrayIndex(row - 1, col));
      }
      if (row < n && isOpen(row + 1, col)) {
        quickUnionUF.union(toArrayIndex(row, col), toArrayIndex(row + 1, col));
      }
      if (col > 1 && isOpen(row, col - 1)) {
        quickUnionUF.union(toArrayIndex(row, col), toArrayIndex(row, col - 1));
      }
      if (col < n && isOpen(row, col + 1)) {
        quickUnionUF.union(toArrayIndex(row, col), toArrayIndex(row, col + 1));
      }
      if (row == 1) {
        quickUnionUF.union(toArrayIndex(row, col), topNode);
      }
      if (row == n) {
        quickUnionUF.union(toArrayIndex(row, col), bottomNode);
      }
      openedSites[toArrayIndex(row, col)] = true;
      numberOfOpenedSites++;
    }
  }

  private void validateRowAndCol(final int row, final int col) {
    if (row < 1 || row > n || col < 1 || col > n) {
      throw new IllegalArgumentException();
    }
  }

  public boolean isOpen(final int row, final int col) {
    validateRowAndCol(row, col);
    return openedSites[toArrayIndex(row, col)];
  }

  private int toArrayIndex(final int row, final int col) {
    return (row - 1) * n + col - 1;
  }

  public boolean isFull(int row, int col) {
    validateRowAndCol(row, col);
    return isOpen(row, col) && quickUnionUF.connected(toArrayIndex(row, col), topNode);
  }

  public int numberOfOpenSites() {
    return numberOfOpenedSites;
  }

  public boolean percolates() {
    return quickUnionUF.connected(topNode, bottomNode);
  }

  public static void main(String[] args) {
    final int n = 20;
    final Percolation percolation = new Percolation(n);
    boolean percolates = false;
    while (!percolates) {
      final int number = StdRandom.uniform(1, n * n + 1);
      percolation.open((int) Math.ceil((double) number / n), number % n + 1);
      percolates = percolation.percolates();
    }
    StdOut.println(percolation.numberOfOpenSites());
  }
}
