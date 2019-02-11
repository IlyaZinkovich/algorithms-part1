package algorithms.part1.unionfind;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;

import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.quicktheories.core.Gen;

class UnionFindTest {

  private static final int N = 1000;
  private static final Gen<Integer> POINT = integers().between(0, N - 1);

  @Test
  void quickFindTest() {
    testUnionFind(QuickFind::new);
  }

  @Test
  void quickUnionTest() {
    testUnionFind(QuickUnion::new);
  }

  @Test
  void quickUnionWeightedTest() {
    testUnionFind(QuickUnionWeighted::new);
  }

  @Test
  void quickUnionPathCompressionOnePassTest() {
    testUnionFind(QuickUnionPathCompressionOnePass::new);
  }

  @Test
  void quickUnionPathCompressionTwoPassTest() {
    testUnionFind(QuickUnionPathCompressionTwoPass::new);
  }

  private void testUnionFind(final Function<Integer, UnionFind> unionFindConstructor) {
    qt().forAll(POINT, POINT, POINT).check((p, q, r) -> {
      final UnionFind quickFindUF = unionFindConstructor.apply(N);
      quickFindUF.union(p, q);
      final boolean reflexive = quickFindUF.connected(p, p);
      final boolean symmetric = quickFindUF.connected(p, q) && quickFindUF.connected(q, p);
      quickFindUF.union(q, r);
      final boolean transitive =
          quickFindUF.connected(p, q) && quickFindUF.connected(q, r) && quickFindUF.connected(p, r);
      return reflexive && symmetric && transitive;
    });
  }
}
