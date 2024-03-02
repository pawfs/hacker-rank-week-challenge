package day6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class LegoBlocksResult {
    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts the following parameters:
     * 1. INTEGER n - height
     * 2. INTEGER m - width
     */

     private static final int MOD = 1000000007; // 10^9+7
     private static final int MAX_SIZE = 1000 + 1; // 1 <= n, m <= 1000
     private static final int UNKNOWN = -1;
   
     static int[][] allSolutions = new int[MAX_SIZE][MAX_SIZE];
     static int[][] solidSolutions = new int[MAX_SIZE][MAX_SIZE];
   
     static {
       for (int i = 1; i < MAX_SIZE; i++) {
         Arrays.fill(allSolutions[i], UNKNOWN);
         Arrays.fill(solidSolutions[i], UNKNOWN);
       }
     }
   
     static int getAllSolutions(final int height, final int width) {
       if (allSolutions[height][width] != UNKNOWN) {
         return allSolutions[height][width];
       }
   
       long count;
       if (width == 1) {
         count = 1;
       } else if (height == 1) {
         if (width <= 4) {
           count = 2 * getAllSolutions(1, width - 1);
         } else { // width > 4
           count = 0;
           for (int i = 1; i <= 4; i++) {
             count += getAllSolutions(1, width - i);
             count %= MOD;
           }
         }
       } else { // width > 1 && height > 1
         int oneRowSolutions = getAllSolutions(1, width);
   
         count = 1;
         for (int h = 0; h < height; h++) {
           count *= oneRowSolutions;
           count %= MOD;
         }
       }
   
       allSolutions[height][width] = (int) count;
       return allSolutions[height][width];
     }
   
     static int legoBlocks(final int height, final int width) {
       if (solidSolutions[height][width] != UNKNOWN) {
         return solidSolutions[height][width];
       }
   
       long count;
       if (width == 1) {
         count = 1;
       } else {
         count = getAllSolutions(height, width);
         for (int i = 1; i < width; i++) {
           long a = getAllSolutions(height, i);
           long b = legoBlocks(height, width - i);
           count -= (a * b) % MOD;
           if (count < 0) {
             count += MOD;
           }
         }
       }
       solidSolutions[height][width] = (int) count;
       return solidSolutions[height][width];
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
