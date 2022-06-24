package two_pointer.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        int end = 0, cnt = 0, sum = 0;
        for (int i = 0; i < list.size(); i++) {
            while (end < list.size() && sum < n) {
               sum += list.get(end);
               end++;
            }

            if (sum == n) {
                cnt++;
            }

            sum -= list.get(i);
        }

        System.out.println(cnt);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            } 
        }

        return true;
    }
}
