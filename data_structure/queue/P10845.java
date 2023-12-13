package data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * P10845
 */
public class P10845 {
    static ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    if (st.hasMoreTokens()) {
                        queue.add(Integer.parseInt(st.nextToken()));                    
                    }
                    break;
                    
                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    sb.append(!queue.isEmpty() ? queue.get(0) : -1).append('\n');
                    break;

                case "back":
                    sb.append(!queue.isEmpty() ? queue.get(queue.size()-1) : -1).append('\n');
                    break;
            
                default:
                    break;
            }
        }

        System.out.println(sb.toString());
        
    }

    static String pop() {
        if (queue.isEmpty()) {
            return "-1";
        }

        Integer num = queue.get(0);
        queue.remove(0);

        return num.toString();
    }
}