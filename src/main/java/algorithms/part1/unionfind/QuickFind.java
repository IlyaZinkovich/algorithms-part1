package algorithms.part1.unionfind;

import java.util.stream.IntStream;

public class QuickFind implements UnionFind {

  private final int[] id;

  public QuickFind(final int N) {
    this.id = IntStream.range(0, N).toArray();
  }

  @Override
  public boolean connected(final int p, final int q) {
    return id[p] == id[q];
  }

  @Override
  public void union(final int p, final int q) {
    int pid = id[p];
    int qid = id[q];
    if (pid != qid) {
      for (int i = 0; i < id.length; i++) {
        if (id[i] == pid) {
          id[i] = qid;
        }
      }
    }
  }
}
