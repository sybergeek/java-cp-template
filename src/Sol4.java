import java.util.*;
import java.io.*;
import lib.IOLeetcode.*;
import utils.Constants.IOMode;

public class Sol4 {
  public static void main(String[] args) {
    IOMode ioMode = IOMode.FILE;
    try {
      FastReader in = new FastReader(ioMode);
      FastWriter out = new FastWriter(ioMode);
      // int testCases = in.nextInt();
      int testCases = 1;
      while (testCases-- > 0) {
        solveWithIO(in, out);
      }
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
  }

  public static void solveWithIO(FastReader in, FastWriter out) throws IOException {
    int[] nums = new int[]{5,2,2,2,9,10};

    out.println(solve(nums, out));
  }

  public static int solve(int[] nums, FastWriter out) throws IOException {
    int n = nums.length;
    int min = Integer.MAX_VALUE;
    int minCount = 0;

    for (int i = 0; i < n; i++) {
      if (nums[i] < min) {
        min = nums[i];
        minCount = 1;
      }
      else if (nums[i] == min) {
        minCount++;
      }
    }

    // check if min is GCD for All numbers
    // if its not GCD then a smaller number exists as GCD and answer is 1
    if (!minIsGCD(nums, min)) return 1;

    if (minCount % 2 == 0) {
      return minCount/2;
    }
    else {
      return (minCount+1)/2;
    }
  }

  public static boolean minIsGCD(int[] nums, int min) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % min != 0) {
        return false;
      }
    }
    return true;
  }
}