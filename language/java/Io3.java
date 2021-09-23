package language.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Io3 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // while(sc.hasNextLine()) {
        //     String input = sc.nextLine();
        //     System.out.println(input);
        // }
        // sc.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }
    
}
