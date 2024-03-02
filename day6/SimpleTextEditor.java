package day6;

import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        try (Scanner input = new Scanner(System.in)) {
            int q = input.nextInt();

            Stack<String> stack = new Stack<>();
            StringBuilder s = new StringBuilder();

            for (int i = 0; i < q; i++) {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        // append W
                        stack.push(s.toString());
                        String w = input.next();
                        s.append(w);
                        break;

                    case 2:
                        // Delete the k last characters of s
                        stack.push(s.toString());
                        int k = input.nextInt();
                        s.delete(s.length() - k, s.length());
                        break;

                    case 3:
                        // Print the kth character of s
                        int kth = input.nextInt();
                        System.out.println(s.charAt(kth - 1));
                        break;

                    case 4:
                        // Undo the last operation of type 1 or 2
                        s.setLength(0);
                        s.append(stack.pop());
                        break;
                }
            }
        }

    }
}
