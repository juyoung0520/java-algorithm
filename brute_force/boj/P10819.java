package brute_force.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10819 {
    static int n, res = 0;
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(res);
    }

    static void permutation(int start) {
        if (start == n) {
            sum();
            return;
        }
        
        for (int i = start; i < n; i++) {
            swap(i, start);
            permutation(start+1);
            swap(i, start);
        }
    }

    static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void sum() {
        int sum = 0;

        for (int i = 1; i < n; i++) {
            sum += Math.abs(arr[i] - arr[i - 1]);
        }

        res = Math.max(res, sum);
    }
    
}
