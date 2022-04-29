package backtracking.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N];

        dfs(0);

        System.out.print(sb);
        br.close();
    }

    static void dfs(int idx) {
        if (idx == M) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = i + 1; // i가 0부터 시작하므로 i+1 넣어줌
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }
}
