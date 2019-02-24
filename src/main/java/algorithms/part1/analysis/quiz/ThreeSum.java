package algorithms.part1.analysis.quiz;

import java.util.Arrays;

public class ThreeSum {

  private final int[] numbers;

  public ThreeSum(final int[] numbers) {
    this.numbers = numbers;
  }

  public int zero() {
    Arrays.sort(numbers);
    int count = 0;
    for (int base = 0; base < numbers.length - 2; base++) {
      int left = base + 1;
      int right = numbers.length - 1;
      while (left < right) {
        if (numbers[base] + numbers[left] + numbers[right] == 0) {
          count++;
          left++;
        } else if (numbers[base] + numbers[left] + numbers[right] > 0) {
          right--;
        } else {
          left++;
        }
      }
    }
    return count;
  }
}
