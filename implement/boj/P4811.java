package implement.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4811 {
    static long[][] dp = new long[31][31];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        dfs(0, 30);

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            sb.append(dfs(0, n) + "\n");
        }

        System.out.println(sb.toString());
        br.close();
    }

    static long dfs(int h, int w) {
        if (w == 0) {
            // 개수 세는 것이니까
            return 1;
        }

        if (dp[h][w] > 0) {
            return dp[h][w];
        }

        // w != 0 임. 한 알일 때
        long count = dfs(h + 1, w - 1);

        if (h != 0) {
            count += dfs(h - 1, w);
        }

        dp[h][w] = count;

        return count;
    }
    
}
