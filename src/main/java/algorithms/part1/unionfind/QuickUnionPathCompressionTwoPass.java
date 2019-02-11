package algorithms.part1.unionfind;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class QuickUnionPathCompressionTwoPass implements UnionFind {

  private final int[] id;
  private final int[] sz;

  public QuickUnionPathCompressionTwoPass(final int N) {
    this.id = IntStream.range(0, N).toArray();
    this.sz = new int[N];
  }

  @Override
  public boolean connected(final int p, final int q) {
    return root(p) == root(q);
  }

  private int root(int i) {
    List<Integer> examinedNodes = new ArrayList<>();
    while (id[i] != i) {
      examinedNodes.add(i);
      i = id[i];
    }
    final int r = i;
    examinedNodes.forEach(node -> id[node] = r);
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
