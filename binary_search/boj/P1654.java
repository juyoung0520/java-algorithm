package binary_search.boj;

import java.util.Arrays;
import java.util.Scanner;

public class P1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] len = new int[k];

        for (int i = 0; i < k; i++) {
            len[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(len);

        long start = 1;
        long end = len[k-1]; 
        long sum = 0;
        long mid = 0;
        long result = 0;

        while (start <= end) {
            sum = 0;
            mid = (start + end) / 2;

            for (long i : len) {
                if (i >= mid) {
                    sum += i / mid;
                }
            }

            if (sum >= n) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
