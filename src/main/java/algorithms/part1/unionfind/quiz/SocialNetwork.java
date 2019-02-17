package algorithms.part1.unionfind.quiz;

import algorithms.part1.unionfind.UnionFind;
import java.util.stream.IntStream;

public class SocialNetwork implements UnionFind {

  private final int[] id;
  private final int[] sz;
  private int maxConnectivity;

  public SocialNetwork(final int N) {
    this.id = IntStream.range(0, N).toArray();
    this.sz = IntStream.generate(() -> 1).limit(N).toArray();
    this.maxConnectivity = 0;
  }

  public boolean isFullyConnected() {
    return maxConnectivity == id.length;
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
      maxConnectivity = Math.max(maxConnectivity, sz[j]);
    } else {
      id[j] = i;
      sz[i] += sz[j];
      maxConnectivity = Math.max(maxConnectivity, sz[i]);
    }
  }
}
