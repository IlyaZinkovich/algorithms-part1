package algorithms.part1.unionfind;

import java.util.stream.IntStream;

public class QuickUnion implements UnionFind {

  private final int[] id;

  public QuickUnion(final int N) {
    this.id = IntStream.range(0, N).toArray();
  }

  @Override
  public boolean connected(final int p, final int q) {
    return root(p) == root(q);
  }

  private int root(int i) {
    while (id[i] != i) {
      i = id[i];
    }
    return i;
  }

  @Override
  public void union(final int p, final int q) {
    int pRoot = root(p);
    int qRoot = root(q);
    id[pRoot] = qRoot;
  }
}
