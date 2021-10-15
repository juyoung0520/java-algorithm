package language.java;

import java.util.*;

public class ArrList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3); 
        list.add(null); 
        //index 1뒤에 10 삽입
        list.add(1,10);

        //index 1 제거
        list.remove(1);  
        list.clear(); 

        list.size();
        // 1번 원소
        list.get(1);

        Collections.sort(list);

        for(Integer i : list) { 
            System.out.println(i);
        }
        
        Iterator<Integer> iter = list.iterator(); 
        while(iter.hasNext()){
            System.out.println(iter.next()); 
        }

        System.out.println(list.contains(1)); 
        System.out.println(list.indexOf(1));
    }
    
}
