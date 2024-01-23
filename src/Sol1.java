import java.util.*;
import java.io.*;
import lib.IOLeetcode.*;
import utils.Constants.IOMode;

public class Sol1 {
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
    int n = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();

    out.printarr(solve(n, x, y, out));
  }

  public static int[] solve(int n, int x, int y, FastWriter out) throws IOException {
    Map<Object, Object> adjList = new HashMap<>();

    // init adjList
    for (int i = 1; i < n; i++) {
      List<Integer> adj = new ArrayList<>();
      adj.add(i+1);
      adjList.put(i, adj);
    }

    for (int i = 1; i < n; i++) {
      List<Integer> adj;
      if (adjList.containsKey(i+1)) {
        adj = (List<Integer>) adjList.get(i+1);
      }
      else {
        adj = new ArrayList<>();
      }
      adj.add(i);
      adjList.put(i+1, adj);
    }

    List<Integer> adj1 = (List<Integer>) adjList.get(x);
    List<Integer> adj2 = (List<Integer>) adjList.get(y);
    adj1.add(y);
    adjList.put(x, adj1);
    adj2.add(x);
    adjList.put(y, adj2);

    out.printmap(adjList);

    int[] ans = new int[n];
    for (int i = 1; i <= n; i++) {
      bfs(i, adjList, ans, n, out);
    }

    return ans;
  }

  public static void bfs(int src, Map<Object, Object> adjList, int[] ans, int n, FastWriter out) throws IOException {
    boolean[] vis = new boolean[n];

    Queue<int[]> bfsQ = new LinkedList<>();
    bfsQ.add(new int[]{src, 0});
    vis[src-1] = true;
    while (!bfsQ.isEmpty()) {
      int[] nextNode = bfsQ.poll();
      for (int neighbor: (List<Integer>) adjList.get(nextNode[0])) {
        if (!vis[neighbor-1]) {
          vis[neighbor-1] = true;
          bfsQ.add(new int[]{neighbor, nextNode[1]+1});
          ans[nextNode[1]]++;
        }
      }
    }
  }
}