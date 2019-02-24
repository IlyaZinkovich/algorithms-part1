package algorithms.part1.analysis.quiz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ThreeSumTest {

  @Test
  void test() {
    assertEquals(1, new ThreeSum(new int[]{-1, 0, 1}).zero());
    assertEquals(0, new ThreeSum(new int[]{-1, 0, 2}).zero());
    assertEquals(2, new ThreeSum(new int[]{-1, 0, 0, 1}).zero());
    assertEquals(2, new ThreeSum(new int[]{-1, 0, 2, -2, 1}).zero());
    assertEquals(3, new ThreeSum(new int[]{-1, 0, 1, 2, -2, 1}).zero());
  }
}
