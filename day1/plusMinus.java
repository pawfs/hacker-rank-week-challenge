import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class PlusMinusResult {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double positiveCount = 0;
        double negativeCount = 0;
        double zerosCount = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                positiveCount++;
            } else if (arr.get(i) < 0) {
                negativeCount++;
            } else {
                zerosCount++;
            }
        }

        double positiveRatio = Math.round((positiveCount / arr.size()) * 1000000) / 1000000.0;
        double negativeRatio = Math.round((negativeCount / arr.size()) * 1000000) / 1000000.0;
        ;
        double zerosRatio = Math.round((zerosCount / arr.size()) * 1000000) / 1000000.0;
        ;

        System.out.println(String.format("%.6f", positiveRatio));
        System.out.println(String.format("%.6f", negativeRatio));
        System.out.println(String.format("%.6f", zerosRatio));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinusResult.plusMinus(arr);

        bufferedReader.close();
    }
}
