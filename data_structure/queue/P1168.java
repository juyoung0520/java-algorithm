package data_structure.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1168 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        List<Integer> queue = new ArrayList<>();

        for (int i = 1;  i <= n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            index += k;
            
            if (index >= queue.size()) {
                index %= queue.size();
            }

            sb.append(queue.remove(index)+ ", ");
        }

        sb.append(queue.remove(0) + ">");
        bw.write(sb.toString() + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
    
}
