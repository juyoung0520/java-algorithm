package divide_conquer.boj;

import java.util.Arrays;
import java.util.Scanner;

public class P2448 {
    static char[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        sc.close();

        graph = new char[n][2*n-1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], ' ');
        }

        printStars(0, n-1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                sb.append(graph[i][j]);
            }
            sb.append('\n');
        }
        
        System.out.println(sb.toString());
    }

    static void printStars(int a, int b, int n) {
        if (n == 3) {
            graph[a][b] = '*';
            graph[a+1][b-1] = graph[a+1][b+1] = '*';
            graph[a+2][b-2] = graph[a+2][b-1] = graph[a+2][b] =  graph[a+2][b+1] = graph[a+2][b+2] = '*';
            return;
        }

        printStars(a, b, n/2);
        printStars(a+n/2, b-n/2, n/2);
        printStars(a+n/2, b+n/2, n/2);
    }
}
