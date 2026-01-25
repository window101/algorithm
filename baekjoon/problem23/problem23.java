package baekjoon.problem23;

import java.io.*;
import java.util.*;

public class problem23 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String s = br.readLine().trim();
            if(s.equals("end")) break;
            boolean result = VerifyPassword(s);
            if (result) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }
    static boolean VerifyPassword(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        boolean first = false;
        boolean second = true;
        boolean third = true;
        for(char c : s.toCharArray()) {
            if(vowels.contains(c)) {
                first = true;
                break;
            }
        }
        int vowelsCnt = 0;
        int consonantCnt = 0;
        for(char c : s.toCharArray()) {
            if(vowels.contains(c)) {
                vowelsCnt++;
                consonantCnt = 0;
            }else {
                consonantCnt++;
                vowelsCnt = 0;
            }
            if(vowelsCnt == 3 || consonantCnt == 3) {
                second = false;
                break;
            }
        }
        char prev = 0;
        for(char c : s.toCharArray()) {
            if(c == prev) {
                if(c != 'e' && c != 'o') {
                    third = false;
                    break;
                }
            }
            prev = c;
        }
        if(first && second && third) {
            return true;
        }else {
            return false;
        }
    }
}
