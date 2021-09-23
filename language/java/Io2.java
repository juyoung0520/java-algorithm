package language.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Io2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        //scanner();
        buffer();
    }

    // 객체 생성 안하고 사용하려면 static
    public static void scanner() {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
        sc.close();
    }

    public static void  buffer() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            String str = br.readLine();

            StringTokenizer st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // String[] str = br.readLine().split(" ");
            // int a = Integer.parseInt(str[0]);
            // int b = Integer.parseInt(str[1]);

            System.out.println(a+b);
        }
        
        
    }
    
}
