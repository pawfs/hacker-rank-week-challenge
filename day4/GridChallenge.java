package day4;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class GridChallengeResult {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
    // Write your code here
        String result = "YES";
        
        List<char[]> sortedGrid = new ArrayList<char[]>();
        
        for (String string : grid) {
            char[] sortedChars = string.toCharArray();
            Arrays.sort(sortedChars);
            sortedGrid.add(sortedChars);
        }
        
        int charsLength = sortedGrid.get(0).length;
        
        for (int i = 0; i < charsLength; i++) {
            for (int j = 0; j < sortedGrid.size()-1; j++) {
                char c1 = sortedGrid.get(j)[i];
                char c2 = sortedGrid.get(j+1)[i];
                if (c1 > c2) result = "NO";
            }
        }
        
        return result;
    }

}

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = GridChallengeResult.gridChallenge(grid);

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
