package language.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Io {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String str = br.readLine();

        // StringTokenizer st = new StringTokenizer(str, " ");
        // int a = Integer.parseInt(st.nextToken());
        // int b = Integer.parseInt(st.nextToken());

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println(a+b);
    }
    
}
