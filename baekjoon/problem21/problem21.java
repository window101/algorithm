package baekjoon.problem21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class problem21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int max = -11111;
        char result = '?';
        char max_key = '?';
        boolean check = false;
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            if(en.getValue() > max) {
                max = en.getValue();
                max_key = en.getKey();
            }
        }
        int cnt = 0;
        for(Map.Entry<Character, Integer> en : map.entrySet()) {
            if(en.getValue() == max) {
                cnt++;
                if(cnt > 1) {
                    check = true;
                }
            }
        }
        if(check) {
            System.out.println(result);
        }else {
            System.out.println(max_key);
        }
    }
}
