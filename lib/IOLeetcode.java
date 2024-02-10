package lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import utils.Constants;

public class IOLeetcode {
  static File inFile = new File(Constants.INPUT_FILE_PATH);
  static File outFile = new File(Constants.OUTPUT_FILE_PATH);

  public static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader(Constants.IOMode inputMode) {
      try {
        if (inputMode == Constants.IOMode.STD) {
          br = new BufferedReader(new InputStreamReader(System.in));
        }
        else if (inputMode == Constants.IOMode.FILE) {
          br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = Constants.EMPTY_STRING;
      try {
        str = br.readLine().trim();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  public static class FastWriter {
    private BufferedWriter bw;

    public FastWriter(Constants.IOMode outputMode) {
      try {
        if (outputMode == Constants.IOMode.STD) {
          this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        else if (outputMode == Constants.IOMode.FILE) {
          this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public void print(Object object) throws IOException {
      bw.append(Constants.EMPTY_STRING + object);
    }

    public void println(Object object) throws IOException {
      print(object);
      bw.append(Constants.NEWLINE_CHAR);
    }

    public void printsp(Object object) throws IOException {
      print(object);
      bw.append(Constants.SPACE_CHAR);
    }

    public void printarr(Object[] array) throws IOException {
      for (int iterator = 0; iterator < array.length; iterator++) {
        printsp(array[iterator]);
      }
      bw.append(Constants.NEWLINE_CHAR);
    }

    public void printarr(int[] array) throws IOException {
      for (int iterator = 0; iterator < array.length; iterator++) {
        printsp(array[iterator]);
      }
      bw.append(Constants.NEWLINE_CHAR);
    }

    public void printarr(long[] array) throws IOException {
      for (int iterator = 0; iterator < array.length; iterator++) {
        printsp(array[iterator]);
      }
      bw.append(Constants.NEWLINE_CHAR);
    }

    public void printarr(double[] array) throws IOException {
      for (int iterator = 0; iterator < array.length; iterator++) {
        printsp(array[iterator]);
      }
      bw.append(Constants.NEWLINE_CHAR);
    }

    public void printarr(String[] array) throws IOException {
      for (int iterator = 0; iterator < array.length; iterator++) {
        printsp(array[iterator]);
      }
      bw.append(Constants.NEWLINE_CHAR);
    }

    public void printlist(List<Object> coll) throws IOException {
      for (int iterator = 0; iterator < coll.size(); iterator++) {
        printsp(coll.get(iterator));
      }
      bw.append(Constants.NEWLINE_CHAR);
    }

    public void printmap(Map<Object, Object> map) throws IOException {
      bw.append(Constants.OPENING_BRACES_CHAR);
      bw.append(Constants.NEWLINE_CHAR);
      for (Object key: map.keySet()) {
        printsp(key);
        printsp(Constants.COLON_CHAR);
        print(map.get(key));
        println(Constants.COMMA_CHAR);
      }
      bw.append(Constants.CLOSING_BRACES_CHAR);
      bw.append(Constants.NEWLINE_CHAR);
    }

    public void close() throws IOException {
      bw.close();
    }
  }
}
