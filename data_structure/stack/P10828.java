package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;

                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
            
                default:
                    break;
            }

        }
    }
    
}
