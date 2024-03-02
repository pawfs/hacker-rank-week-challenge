package day6;

import java.io.*;
import java.util.stream.*;

class LegoBlocksResult {
    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts the following parameters:
     * 1. INTEGER n - height
     * 2. INTEGER m - width
     */

    static long MOD = 1000000000 + 7;

    static long getResult(long[] total, long[] result, int i) {
        if (result[i] == -1) {
            if (i == 1) {
                result[i] = 1;
            } else {
                result[i] = total[i];
                for (int j = 1; j < i; j++) {
                    result[i] -= (getResult(total, result, j) * total[i - j]) % MOD;
                }
            }
        }
        return result[i];
    }

    static long fillTotal(long[] total, int i) {
        if (i < 0)
            return 0;

        if (total[i] == -1) {
            if (i == 0 || i == 1)
                total[i] = 1;
            else
                total[i] = (fillTotal(total, i - 1) + fillTotal(total, i - 2) + fillTotal(total, i - 3)
                        + fillTotal(total, i - 4)) % MOD;
        }

        return total[i];
    }

    public static int legoBlocks(int n, int m) {
        // Write your code here
        if (n < 2 || m < 1)
            return 0;
        if (m == 1)
            return 1;

        long[] total = new long[m + 1];

        for (int i = 0; i < total.length; i++)
            total[i] = -1;

        fillTotal(total, m);

        for (int i = 0; i < total.length; i++) {
            long tmp = 1;
            for (int j = 0; j < n; j++) {
                tmp = (tmp * total[i]) % MOD;
            }
            total[i] = tmp;
        }

        long[] result = new long[m + 1];

        for (int i = 0; i < result.length; i++)
            result[i] = -1;

        getResult(total, result, m);

        return (int) (result[m] % MOD);
    }

}

public class LegoBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = LegoBlocksResult.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
