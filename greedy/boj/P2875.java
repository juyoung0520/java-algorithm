package greedy.boj;

import java.util.Scanner;

public class P2875 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        sc.close();

        int team = n/2 < m ? n/2 : m;

        k -= n + m - (team * 3);

        while (k > 0) {
            k -= 3;
            team--;
        }

        System.out.println(team);
    }
    
}
