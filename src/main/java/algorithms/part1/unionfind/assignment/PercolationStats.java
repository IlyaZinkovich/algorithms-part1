package algorithms.part1.unionfind.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  private static final double FORMULA_CONSTANT = 1.96D;
  private final double[] results;

  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    } else {
      this.results = new double[trials];
      for (int i = 0; i < trials; i++) {
        final Percolation percolation = new Percolation(n);
        boolean percolates = false;
        while (!percolates) {
          final int number = StdRandom.uniform(1, n * n + 1);
          percolation.open((int) Math.ceil((double) number / n), number % n + 1);
          percolates = percolation.percolates();
        }
        results[i] = (double) percolation.numberOfOpenSites() / (n * n);
      }
    }
  }

  public double mean() {
    return StdStats.mean(results);
  }

  public double stddev() {
    return StdStats.stddev(results);
  }

  public double confidenceLo() {
    return mean() - (FORMULA_CONSTANT * stddev()) / Math.sqrt(results.length);
  }

  public double confidenceHi() {
    return mean() + (FORMULA_CONSTANT * stddev()) / Math.sqrt(results.length);
  }

  public static void main(String[] args) {
    final int n = Integer.parseInt(args[0]);
    final int trials = Integer.parseInt(args[1]);
    final PercolationStats stats = new PercolationStats(n, trials);
    StdOut.printf("mean                    = %.16f%n", stats.mean());
    StdOut.printf("stddev                  = %.16f%n", stats.stddev());
    StdOut.printf("95%% confidence interval = [%.16f, %.16f]%n",
        stats.confidenceLo(), stats.confidenceHi());
  }
}
