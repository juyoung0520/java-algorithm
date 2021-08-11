package dynamic_programming.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P2951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char first[] = br.readLine().toCharArray();
        char second[] = br.readLine().toCharArray();

        int firstLen = first.length;
        int secondLen = second.length;
        
        // 0일때 에러 안나도록 인덱스 하나씩 추가
        int dp[][] = new int[firstLen + 1][secondLen + 1];

        for (int i = 1; i < firstLen + 1; i++) {
            for (int j = 1; j < secondLen + 1; j++) {
                // dp 데이터 하나씩 뒤로 밀렸으므로
                if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[firstLen][secondLen]);
    }
    
}
