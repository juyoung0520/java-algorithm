package brute_force.boj;
import java.util.Scanner;

public class P1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        sc.close();
        int minNum = 0;
        while (!(e == s && s == m)) {
            minNum = Math.min(e, Math.min(s, m));

            if (minNum == e) {
                e += 15;
            } else if (minNum == s) {
                s += 28;
            } else {
                m += 19;
            }

        }

        System.out.println(e);
    }
}
