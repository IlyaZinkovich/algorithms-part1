package algorithms.part1.unionfind.quiz;

import algorithms.part1.unionfind.UnionFind;
import java.util.stream.IntStream;

public class UnionFindCanonicalElement implements UnionFind {

  private final int[] id;
  private final int[] sz;
  private final int[] max;

  public UnionFindCanonicalElement(final int N) {
    this.id = IntStream.range(0, N).toArray();
    this.sz = IntStream.generate(() -> 1).limit(N).toArray();
    this.max = IntStream.range(0, N).toArray();
  }

  public int find(final int i) {
    return max[root(i)];
  }

  @Override
  public boolean connected(final int p, final int q) {
    return root(p) == root(q);
  }

  private int root(int i) {
    while (id[i] != i) {
      id[i] = id[id[i]];
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
      max[j] = Math.max(max[j], max[i]);
    } else {
      id[j] = i;
      sz[i] += sz[j];
      max[i] = Math.max(max[i], max[j]);
    }
  }
}
