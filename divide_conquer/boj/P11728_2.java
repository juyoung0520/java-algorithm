package divide_conquer.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 이게 더 시간 오래걸림;;
public class P11728_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Integer> list1 = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list1.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> list2 = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            list2.add(Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> joined = new ArrayList<>();
        joined.addAll(list1);
        joined.addAll(list2);

        Collections.sort(joined);

        StringBuilder sb = new StringBuilder();
        for (int num : joined) {
            sb.append(num+" ");
        }

        System.out.println(sb.toString());
    }
    
}
