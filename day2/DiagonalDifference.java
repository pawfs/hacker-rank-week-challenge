package day2;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class DiagonalDifferenceResult {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

     public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
            int difference = 0;
            int leftToRightDiagonal = 0;
            int rightToLeftDiagonal = 0;
            
            for (int i = 0; i < arr.size(); i++) {
                leftToRightDiagonal += arr.get(i).get(i);
                rightToLeftDiagonal += arr.get(i).get(arr.size()-i-1);
                }
            
            difference = Math.abs(leftToRightDiagonal - rightToLeftDiagonal);
            
            return difference;
        }

}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifferenceResult.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
