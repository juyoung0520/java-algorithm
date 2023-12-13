package data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1;  i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        while(!queue.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll()).append(", ");
        }

        sb.delete(sb.length()-2, sb.length());
        sb.append(">");

        System.out.println(sb.toString());
    }
    
}
