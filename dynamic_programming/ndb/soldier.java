package dynamic_programming.ndb;

import java.util.*;

public class soldier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> soldier = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            soldier.add(sc.nextInt());
        }
        Collections.reverse(soldier);

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(soldier.get(j) < soldier.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }

        System.out.println(n - maxValue);
        sc.close();
    }
    
}
