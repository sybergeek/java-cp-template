import java.util.*;
import java.io.*;
import lib.IOLeetcode.*;
import utils.Constants.IOMode;

public class Sol2 {
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
    double[] nums = new double[]{1,2,3,12};
    out.printarr(nums);
    out.println(solve(nums));
  }

  public static long solve(double[] nums) {
    return Long.valueOf(0);
  }
}