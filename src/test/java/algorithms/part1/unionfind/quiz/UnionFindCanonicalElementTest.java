package algorithms.part1.unionfind.quiz;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.quicktheories.core.Gen;

class UnionFindCanonicalElementTest {

  private static final int N = 100;

  @Test
  void findCanonicalElementTest() {
    final UnionFindCanonicalElement unionFindCanonicalElement = new UnionFindCanonicalElement(N);
    IntStream.range(0, N - 1).forEach(i -> unionFindCanonicalElement.union(i, N - 1));
    assertTrue(IntStream.range(0, N).allMatch(i -> unionFindCanonicalElement.find(i) == N - 1));
  }

  @Test
  void findCanonicalElementPairTest() {
    final Gen<Integer> node = integers().between(0, N - 1);
    qt().forAll(node, node).check((first, second) -> {
      final UnionFindCanonicalElement unionFindCanonicalElement = new UnionFindCanonicalElement(N);
      unionFindCanonicalElement.union(first, second);
      final int max = Math.max(first, second);
      return unionFindCanonicalElement.find(first) == max &&
          unionFindCanonicalElement.find(second) == max;
    });
  }
}
