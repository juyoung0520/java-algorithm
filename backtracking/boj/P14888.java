package backtracking.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class P14888 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] operations = new int[4];
        
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operations.length; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        } 

        dfs(arr[0], 0, arr, operations);

        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    static void dfs(int sum, int idx, int[] arr, int[] operations) {
        if (idx == arr.length - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < operations.length; i++) {
            if (operations[i] >= 1) {
                operations[i]--;
                switch (i) {
                    case 0:
                        dfs(sum + arr[idx+1], idx+1, arr, operations);
                        break;
                    case 1:
                        dfs(sum - arr[idx+1], idx+1, arr, operations);
                        break;
                    case 2:
                        dfs(sum * arr[idx+1], idx+1, arr, operations);
                        break;
                    case 3:
                        dfs(sum / arr[idx+1], idx+1, arr, operations);
                        break;
                }
                operations[i]++;
            }
        }

    }
}
