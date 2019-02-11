package algorithms.part1.unionfind;

import java.util.stream.IntStream;

public class QuickUnionWeighted implements UnionFind {

  private final int[] id;
  private final int[] sz;

  public QuickUnionWeighted(final int N) {
    this.id = IntStream.range(0, N).toArray();
    this.sz = new int[N];
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
    int i = root(p);
    int j = root(q);
    if (i == j) {
      return;
    } else if (sz[i] > sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }
  }
}
