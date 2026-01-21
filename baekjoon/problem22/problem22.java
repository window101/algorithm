package baekjoon.problem22;

import java.io.*;
import java.util.*;

public class problem22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            String name = br.readLine().trim();
            char i_name = name.charAt(0);
            map.put(i_name, map.getOrDefault(i_name, 0)+1);
        }
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            if(en.getValue() >= 5) {
                list.add(en.getKey());
            }   
        }
        if(list.size() == 0) {
            System.out.println("PREDAJA");
            return;
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
