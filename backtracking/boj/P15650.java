package backtracking.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(n, m, 0, 0);
        
        System.out.println(sb.toString());
        br.close();
    }

    public static void dfs(int n, int m, int idx, int start) {
        if (idx == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
            arr[idx] = i + 1;
            dfs(n, m, idx + 1, i + 1);
        }
    }
    
}
