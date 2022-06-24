package backtracking.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {
    static int[][] arr;
    static boolean[] team;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        team = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(n, 0, 0);

        System.out.println(min);
        br.close();
    }

    public static void dfs(int n, int idx, int start) {
        if (idx == n / 2) {
            int team1 = 0, team2 = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1;  j < n; j++) {
                    if (team[i] && team[j]) {
                        team1 += arr[i][j];
                        team1 += arr[j][i];
                    } else if (!team[i] && !team[j]) {
                        team2 += arr[i][j];
                        team2 += arr[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(team1 - team2));
            return;
        }

        for (int i = start; i < n; i++) {
            team[i] = true;
            dfs(n, idx + 1, i + 1);
            team[i] = false;
        }
    }
}
