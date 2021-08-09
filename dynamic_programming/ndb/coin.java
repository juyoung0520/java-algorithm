package dynamic_programming.ndb;
import java.util.*;

public class coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc. nextInt();

        int coin[] = new int[n];
        for (int i = 0; i < coin.length; i++) {
            coin[i] = sc.nextInt();
        }

        int dp[] = new int[m + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i: coin) {
            for (int j = i; j <= m; j++) {
                if (dp[j - i] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - i] + 1);
                }
            }
        }

        if (dp[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }

        sc.close();
    }
    
}
