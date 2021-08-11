package dynamic_programming.boj;
import java.util.*;

/**
 * p9095
 */
public class P9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dp[] = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4 ; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            System.out.println(dp[sc.nextInt()]);
        }

        sc.close();
    }
    
}