package day5;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class BalancedBracketsResult {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static boolean matchingBrackets(char b1, char b2) {
        if (b1 == '{' && b2 == '}') {
            return true;
        } else if (b1 == '(' && b2 == ')') {
            return true;
        } else if (b1 == '[' && b2 == ']') {
            return true;
        }
        return false;
    }

    public static String isBalanced(String s) {
        // Write your code here
        char[] stringArray = s.toCharArray();

        if (s.length() % 2 != 0) {
            return "NO";
        }

        Stack<Character> unmatchedBrackets = new Stack<Character>();

        for (int i = 0; i < stringArray.length; i++) {
            char current = stringArray[i];
            if (current == '{' || current == '[' || current == '(') {
                unmatchedBrackets.add(current);
            } else {
                if (unmatchedBrackets.isEmpty()) {
                    return "NO";
                } else if (matchingBrackets(unmatchedBrackets.peek(), current)) {
                    unmatchedBrackets.pop();
                }
            }
        }

        if (unmatchedBrackets.isEmpty()) {
            return "YES";
        }

        return "NO";
    }

}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBracketsResult.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
