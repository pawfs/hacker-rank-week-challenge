package day5;

import java.util.*;

public class QueueUsingStacks {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            while (q-- > 0) {
                int i = in.nextInt();
                if (i == 1) {
                    // enqueue element x
                    int x = in.nextInt();
                    s2.push(x);
                } else {
                    if (s1.isEmpty()) {
                        while (!s2.isEmpty()) {
                            s1.push(s2.pop());
                        }
                    }
                }
                if (i == 2) {
                    // dequeue element at the front
                    s1.pop();
                } else if (i == 3) {
                    // print element at the front
                    System.out.println(s1.peek());
                }
            }
        }
    }
}
