package divide_conquer.boj;

import java.util.Scanner;

public class P11729 {
    static StringBuilder sb;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        sb = new StringBuilder();
        
        hanoi(n, 1, 3);

        System.out.println(count);
        System.out.println(sb.toString());
    }

    static void hanoi(int n, int start, int end) {
        if (n == 1) {
            sb.append(start+" "+end+"\n");
            count++;
        } else {
            // n-1까지를 시작점과 끝 점 아닌 곳으로 옮김.
            hanoi(n-1, start, 6-start-end);
            //자신 옮김
            sb.append(start+" "+end+"\n");
            count++;
            // n-1까지를 다시 도착지로 옮김.
            hanoi(n-1, 6-start-end, end);
        }
    }
}
