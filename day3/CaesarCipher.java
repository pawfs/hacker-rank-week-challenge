package day3;

import java.io.*;

class CaesarCipherResult {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        String cipher = "";
        char[] ch = s.toCharArray();
        k = k % 26;

        for (int i = 0; i < ch.length; i++) {
            if (!Character.isLetter(ch[i])) {
                cipher += ch[i];
            } else {
                int cipherInt = (int) ch[i] + k;
                int c = (int) ch[i];

                if (c >= 97 && c <= 122) {
                    if (cipherInt > 122)
                        cipherInt = cipherInt - 26;

                }
                if (c >= 65 && c <= 90) {
                    if (cipherInt > 90)
                        cipherInt = cipherInt - 26;

                }
                char cipherChar = (char) cipherInt;
                cipher += cipherChar;

            }
        }
        return cipher;
    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = CaesarCipherResult.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
