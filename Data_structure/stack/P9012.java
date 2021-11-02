package data_structure.stack;

import java.util.Scanner;
import java.util.Stack;

public class P9012 {
    static StringBuilder sb;
    static Stack<Character> stack;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        
        sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            String str = sc.next();

            sb.append(solve(str)).append('\n');
        }

        sc.close();

        System.out.println(sb.toString());
    }

    static String solve(String str) {
        stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                // 스택이 비어있는데 ')'가 들어오는 경우
                return "NO";
            } else {
                // () vps 찾아서 pop
                stack.pop();
            }
        }

        // 스택이 비어있으면 vps, 아니면 '('가 많은 경우
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    static boolean vps() {
        int count = 0;

        while (!stack.isEmpty()) {
            switch (stack.pop()) {
                case '(':
                    if (count == 0) {
                        return false;
                    }
                    count--;
                    break;

                case ')':
                    count++;
                    break;
                
                default:
                    break;
            }
        }

        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
