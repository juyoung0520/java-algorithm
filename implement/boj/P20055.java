package implement.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20055 {
    static int n, k;
    static int[] belt;
    static boolean[] robots;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[n*2 + 1];
        robots = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n*2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int step = 1;   
        while (true) {
            // 1. 컨베이어 밸트 이동
            moveBelt();
            // 2. 로봇 이동
            moveRobots();
            // 3. 로봇 올리기
            putRobot();
            // 4. 종료 check
            if (checkEnd()) {
                System.out.println(step);
                break;
            }
            step++;
        }

        br.close();
    }

    static void moveBelt() {
        int last = belt[n*2];
        for (int i = n*2; i > 1; i--) {
            belt[i] = belt[i-1];
        } 
        belt[1] = last;

        for (int i = n; i > 1; i--) {
            robots[i] = robots[i-1]; 
        }
        robots[1] = false;
    }
    
    static void moveRobots() {
        if (robots[n]) {
            robots[n] = false;
        }

        for (int i = n-1; i >= 1; i--) {
            if (robots[i] && !robots[i+1] && belt[i+1] > 0) {
                belt[i+1]--;
                robots[i] = false;
                robots[i+1] = true;
            }
        }

        if (robots[n]) {
            robots[n] = false;
        }
    }

    static void putRobot() {
        if (belt[1] > 0) {
            belt[1]--;
            robots[1] = true;
        }
    }

    static boolean checkEnd() {
        int check = 0;
        for (int i = 1; i <= n*2; i++) {
            if (belt[i] == 0) {
                check++;
            }
        }

        if (check >= k) {
            return true;
        }

        return false;
    }
    
}
