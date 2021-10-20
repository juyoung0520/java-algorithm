package binary_search.boj;

import java.util.Arrays;
import java.util.Scanner;

public class P2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(house);

        int min = 1;
        int max = house[n-1] - house[0];
        int res = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 1;
            int current = house[0];
            
            for (int i : house) {
                if (i - current >= mid) {
                    count++;
                    current = i;
                }
            }

            if (count < c) {
                max = mid - 1;
            } else {
                res = mid;
                min = mid + 1;
            }
        }

        System.out.println(res);
        
    }
    
}
