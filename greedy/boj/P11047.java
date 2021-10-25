package greedy.boj;

import java.util.Scanner;

public class P11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int total = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        sc.close();

        int count = 0;

        for (int i = n-1; i >= 0; i--) {
            if (coins[i] <= total) {
                count += total / coins[i];
                total %= coins[i];

                if (total == 0) {
                    break;
                }
            }
        }

        System.out.println(count);  
    }
    
}
