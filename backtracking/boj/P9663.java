package backtracking.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {
    static int[] arr; // 인덱스가 열, 값이 행
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(n, 0);

        System.out.println(count);
        br.close();
    }

    public static void dfs(int n, int idx) {
        if (idx == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[idx] = i;

            // 이 자리에 놓는 것이 가능하면 다음 탐색
            if (isPossible(idx)) {
                dfs(n, idx + 1);
            }
        }
    }

    public static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            // 앞선 행 같은 열에 놓인 것 있는지 (뒷 행은 아직 없음)
            if (arr[i] == arr[row]) {
                return false;
            } 
            // 대각선에 있는지 
            else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
