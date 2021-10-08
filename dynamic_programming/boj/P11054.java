package dynamic_programming.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11054 {
    static int n;
    static int[] seq;
    static int[] fDp;
    static int[] bDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // i까지 증가하는 수열
        fDp = new int[n];
        LIS();

        bDp = new int[n];
        LDS();

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, fDp[i] + bDp[i]);
        }

        // 기준 원소 두 번 들어감
        System.out.println(max - 1);
    }

    static void LIS() {
        for (int i = 0; i < n; i++) {
            fDp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    fDp[i] = Math.max(fDp[i], fDp[j] + 1);
                }
            }
        }
    }

    static void LDS() {
        for (int i = n-1; i >= 0; i--) {
            bDp[i] = 1;

            for (int j = n-1; j > i;j--) {
                if (seq[j] < seq[i]) {
                    bDp[i] = Math.max(bDp[i], bDp[j] + 1);
                }
            }
        }
    }
    
}
