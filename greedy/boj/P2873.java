package greedy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2873 {
    static int r, c;
    static int[][] joy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        joy = new int[r][c];

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < r; j++) {
                joy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (r < c || (r == c && joy[0][1] < joy[1][0])) {
            for (int i = 0; i < c; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < r; j++) {
                        if (j == r-1) {
                            sb.append('R');
                        } else {
                            sb.append('D');
                        }
                    }
                } else {
                    for (int j = r-1; j >= 0; j--) {
                        if (j == 0) {
                            sb.append('R');
                        } else {
                            sb.append('U');
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < r; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < c; j++) {
                        if (j == c-1) {
                            sb.append('D');
                        } else {
                            sb.append('R');
                        }
                    }
                } else {
                    for (int j = c-1; j >= 0; j--) {
                        if (j == 0) {
                            sb.append('D');
                        } else {
                            sb.append('L');
                        }
                    }
                }
            }
        }
        
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
    
}
