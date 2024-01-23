import java.util.*;
import java.io.*;

public class SolCF {
  static File inFile = new File("./io/in.txt");
  static File outFile = new File("./io/out.txt");
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
      try {
        // br=new BufferedReader(new InputStreamReader(System.in));
        br=new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    String next() {
      while(st==null || !st.hasMoreTokens()){
        try {
          st=new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
    int nextInt() {
      return Integer.parseInt(next());
    }
    long nextLong(){
      return Long.parseLong(next());
    }
    double nextDouble(){
      return Double.parseDouble(next());
    }
    String nextLine(){
      String str="";
      try {
        str=br.readLine().trim();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  static class FastWriter {
  private BufferedWriter bw;

  public FastWriter() {
    try {
    // this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  public void print(Object object) throws IOException {
    bw.append("" + object);
  }

  public void println(Object object) throws IOException {
    print(object);
    bw.append("\n");
  }

  public void printsp(Object object) throws IOException {
    print(object);
    bw.append(" ");
  }

  public void close() throws IOException {
    bw.close();
  }
}

  public static void main(String[] args) {
    try {
      FastReader in = new FastReader();
      FastWriter out = new FastWriter();
      // int testCases = in.nextInt();
      int testCases = 1;
      while(testCases-- > 0){
        // write code here
        solveWithIO(in, out);
      }
      out.close();
    } catch (Exception e) {
      return;
    }
  }

  public static void solveWithIO(FastReader in, FastWriter out) throws IOException {
    String s = "isawsquirrelnearmysquirrelhouseohmy", a = "my", b = "squirrel";
    int k = 15;
    // out.println(s);

    List<Integer> ans = solve(s, a, b, k);
    out.println(ans.size());
    for (int i: ans) {
        out.printsp(i);
    }
  }

  public static List<Integer> solve(String s, String a, String b, int k) {
    int slen = s.length();
    int alen = a.length();
    int blen = b.length();
    List<Integer> ans = new ArrayList<>();

    List<Integer> aIndices = matchStarts(s, a, slen, alen);
    List<Integer> bIndices = matchStarts(s, b, slen, blen);

    for (int i = 0; i < aIndices.size(); i++) {
        int element = aIndices.get(i);
        if (search(bIndices, element, k)) {
            ans.add(element);
        }
    }

    return ans;
  }

  private static List<Integer> matchStarts(String s, String a, int slen, int alen) {
    List<Integer> indices = new ArrayList<>();
    int validPos = s.indexOf(a);
    while (validPos != -1) {
        indices.add(validPos);
        validPos = s.indexOf(a, validPos + 1);
    }
    return indices;
  }

  private static boolean search(List<Integer> bIndices, int key, int k) {
    int beg = 0, end = bIndices.size() - 1;
    int mid;
    while (beg <= end) {
        mid = (beg + end)/2;
        if (Math.abs(bIndices.get(mid) - key) <= k) {
            return true;
        }
        else if (key > bIndices.get(mid)) {
            beg = mid + 1;
        }
        else {
            end = mid - 1;
        }
    }

    return false;
  }
}