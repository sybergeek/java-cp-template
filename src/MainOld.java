import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainOld {
    static char[] array = new char[100];
    public static void main(String[] args) throws IOException {
        final InputStreamReader reader = new InputStreamReader(System.in);
//        int n = reader.read();
        int n;
        int testcases = reader.read(array);
        System.out.println("Testcases: " + testcases);
        while (testcases >= 0) {
            n = reader.read();
            System.out.println(new Solver().solve(n));
            testcases--;
        }
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        System.out.print("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);
//        }

//        System.out.println(new Solver().solve(n));
    }
}

class Solver {
    public String solve(int n) {
        final StringBuilder stringBuilder = new StringBuilder();

        if (n == 9) {
            stringBuilder.append("NO");
        }
        else if ((n >= 7) && (n % 3 == 0)) {
            stringBuilder.append("YES\n").append(1).append(' ').append(4).append(' ').append(n-5);
        }
        else if (n >= 7) {
            stringBuilder.append("YES\n").append(1).append(' ').append(2).append(' ').append(n-3);
        }
        else {
            stringBuilder.append("NO");
        }

//        for (int i = 0; i <= n; i++) {
//            stringBuilder.append(i).append(' ');
//        }
        return stringBuilder.toString();
    }
}