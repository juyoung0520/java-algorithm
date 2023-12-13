package data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P10866 {
    static List<Integer> dequeue = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    dequeue.add(0, Integer.parseInt(st.nextToken()));
                    break;
                    
                case "push_back":
                    dequeue.add(Integer.parseInt(st.nextToken()));
                    break;
            
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                    
                    case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;
                    
                    case "size":
                    sb.append(dequeue.size()).append('\n');
                    break;
            
                case "empty":
                    sb.append(dequeue.isEmpty() ? 1 : 0).append('\n');
                    break;
            
                case "front":
                    sb.append(!dequeue.isEmpty() ? dequeue.get(0) : -1).append('\n');     
                    break;
                    
                    case "back":
                    sb.append(!dequeue.isEmpty() ? dequeue.get(dequeue.size()-1) : -1).append('\n');     
                    break;
            
                default:
                    break;
            }
        }
        
        System.out.println(sb.toString());
    }

    static String pop_front() {
        if (dequeue.isEmpty()) {
            return "-1";
        }

        Integer num = dequeue.get(0);
        dequeue.remove(0);

        return num.toString();
    }

    static String pop_back() {
        if (dequeue.isEmpty()) {
            return "-1";
        }

        Integer num = dequeue.get(dequeue.size()-1);
        dequeue.remove(dequeue.size()-1);

        return num.toString();
    }
}
