package greedy.boj;

import java.util.Arrays;
import java.util.Scanner;

public class P11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(time);

        int sum = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            sum += time[i];
            total += sum;
        }

        System.out.println(total);
        
    }
    
}

