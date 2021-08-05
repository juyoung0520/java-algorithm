package binary_search.boj;
import java.util.*;

/**
 * p2343
 */
public class p2343 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = 0;
        int end = 0;
        int[] lessons = new int[n];

        for(int i = 0; i < n; i++) {
            lessons[i] = sc.nextInt();
            end += lessons[i];
            start = Math.max(lessons[i], start);
        }

        int mid = 0;
        int res = 0;
        int total, count;

        while (start <= end) {
            mid = (start + end) / 2;
            total = 0;
            count = 1;

            for (int i: lessons) {
                if(i + total > mid) {
                    total = 0;
                    count += 1;
                }
                total += i;
            }

            if (count > m) {
                start = mid + 1;
            } else {
                res = mid;
                end = mid - 1;
            }
        }

        System.out.println(res);
        sc.close();
    }
}