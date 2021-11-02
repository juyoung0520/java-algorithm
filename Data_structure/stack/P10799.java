package data_structure.stack;

import java.util.Scanner;
import java.util.Stack;

public class P10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        sc.close();

        Stack<Character> stack = new Stack<>();

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();

                if (str.charAt(i-1) == '(') {
                    sum += stack.size();
                } else {
                    sum += 1;
                }
            } 
        }

        System.out.println(sum);
    }
    
}
