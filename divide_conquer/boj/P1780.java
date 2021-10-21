package divide_conquer.boj;

import java.util.Scanner;

public class P1780 {
    static int[][] graph;
    static int RES1 = 0;
    static int RES2 = 0;
    static int RES3 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        sc.close();

        divide(0, 0, N);

        System.out.println(RES1);
        System.out.println(RES2);
        System.out.println(RES3);   
    }

    static void divide(int row, int col, int size) {

        // 모든 면이 다 같은 숫자인지 확인, size 1일 때 무조건 true여서 break point
        if (checkFill(row, col, size)) {
            if (graph[row][col] == -1) {
                RES1++;
            } else if (graph[row][col] == 0) {
                RES2++;
            } else {
                RES3++;
            }

            return;
        }

        // 분할
        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(row + newSize * i, col + newSize * j, newSize);
            }
        }
    }

    static boolean checkFill(int row, int col, int size) {
        int res = graph[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (graph[i][j] != res) {
                    return false;
                }
            }
        }

        return true;
    }
    
}
