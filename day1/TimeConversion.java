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

class TimeConversionResult {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String convertedTime = "";
        if (s.contains("AM") && !s.contains("12")) {
            convertedTime = s.replaceFirst("AM", "");

        } else if (s.contains("AM") && s.contains("12")) {
            convertedTime = s.replaceFirst("AM", "");
            convertedTime = convertedTime.replaceFirst("12", "00");

        } else if (s.contains("PM") && s.contains("12")) {
            convertedTime = s.replaceFirst("PM", "");

        } else {
            String hoursString = s.substring(0, 2);
            int hours12Format = Integer.parseInt(hoursString);
            int hours24Format = 12 + hours12Format;
            String hours24FormatString = "";
            if (hours24Format < 10) {
                hours24FormatString = "0" + String.valueOf(hours24Format);

            } else {
                hours24FormatString = String.valueOf(hours24Format);
            }
            convertedTime = hours24FormatString + s.substring(2, 8);

        }
        return convertedTime;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversionResult.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
