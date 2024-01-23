import java.util.*;
import java.io.*;
import lib.IOLeetcode.*;
import utils.Constants.IOMode;

public class Sol3 {
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
    String word = "aabbccddeeffgghhiiiiii";

    out.println(solve(word, out));
  }

  public static int solve(String word, FastWriter out) throws IOException {
    int n = word.length();
    int ans = 0;
    Map<Character, Integer> count = new HashMap<>();
    Map<Character, Integer> cost = new HashMap<>();
    final class Pair {
      Character letter;
      Integer frequency;
    }
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> (b.frequency - a.frequency));

    for (int i = 0; i < n; i++) {
      char lett = word.charAt(i);
      if (count.containsKey(lett)) {
        count.put(lett, count.get(lett) + 1);
      }
      else {
        count.put(lett, 1);
      }
    }

    for (char lett: count.keySet()) {
      Pair pair = new Pair();
      pair.letter = lett;
      pair.frequency = count.get(lett);
      maxHeap.add(pair);
    }

    int cnt8 = 1;
    while (!maxHeap.isEmpty()) {
      Pair pair = maxHeap.poll();
      // int[] pair = maxHeap.poll();
      if (cnt8 <= 8) {
        cost.put(pair.letter, 1);
      }
      else if (cnt8 <= 16) {
        cost.put(pair.letter, 2);
      }
      else if (cnt8 <= 24) {
        cost.put(pair.letter, 3);
      }
      else {
        cost.put(pair.letter, 4);
      }
      cnt8++;
    }

    for (char lett: count.keySet()) {
      ans += count.get(lett) * cost.get(lett);
    }

    return ans;
  }
}