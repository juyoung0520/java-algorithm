package greedy.boj;

import java.util.Scanner;

public class P1783 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.close();

        if (n == 1) {
            // 1일 때 움직일 수 있는 방향 없음. 나가는 것만 가능
            System.out.println(1);
        } else if (n == 2) {
            // 2일 때 2, 3번 방법만 가능. 4번까지는 방향 맘대로 움직일 수 있음.
            // +1은 나가는 것
            System.out.println(Math.min(4, (m+1)/2));
        } else if (m < 7) {
            // 4방향 모두 사용하려면 최소 m은 7은 되어야된다.
            // 그 전까지는 4방향 불가.최대 4번 가능. 1, 4번이 이동 가장 많이 할 수 있다.
            System.out.println(Math.min(4, m));
        } else {
            // 최소 한 번씩은 2, 3번으로 움직여야 함. m-1 + -2 + 1
            System.out.println(m-2);
        }
    }
    
}
