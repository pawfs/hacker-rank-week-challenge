package day4;

import java.io.*;

class RecursiveDigitSumResult {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
    // Write your code here
        if (n.length() == 1 && k == 1) {
            return Integer.valueOf(n);
        } else {
            String[] digits = n.split("");
            long sum = 0;
            for (String digit : digits) {
                sum+= Integer.valueOf(digit);
            }
            sum = sum * k;
            return superDigit(String.valueOf(sum), 1);
        }
        
    }

}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = RecursiveDigitSumResult.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}