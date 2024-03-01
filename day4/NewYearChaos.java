package day4;

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

class NewYearChaosResult {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int totalBribes = 0;

        for (int i = q.size() - 1; i >= 0; i--) {

            while (q.get(i) - 1 > i) {
                int value = q.get(i);
                int currentBribes = value - i - 1;
                if (currentBribes > 2) {
                    System.out.println("Too chaotic");
                    return;
                } else if (currentBribes == 2) {
                    q.set(i, q.get(i + 1));
                    q.set(i + 1, q.get(i + 2));
                    q.set(i + 2, value);
                } else {
                    q.set(i, q.get(i + 1));
                    q.set(i + 1, value);
                }
                totalBribes += currentBribes;
            }

        }
        System.out.println(totalBribes);
    }

}

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                NewYearChaosResult.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
