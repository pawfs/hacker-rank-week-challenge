package other;

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

class TruckTourResult {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        final int size = petrolpumps.size();

        for (int start = 0; start < size; start++) {
            List<Integer> currentPump = petrolpumps.get(start);
            if (currentPump.get(0) < currentPump.get(1))
                continue;

            long totalLiters = 0;
            int position = start;
            int pumpCount = 0;

            while (true) {
                if (pumpCount == size)
                    return start; // all pumps has been visited
                if (totalLiters < 0)
                    break; // not enough petrol to move further

                List<Integer> pump = petrolpumps.get(position % size);
                totalLiters += pump.get(0) - pump.get(1);
                position++;
                pumpCount++;
            }
        }
        return -1;
    }

}

public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = TruckTourResult.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
