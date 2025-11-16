package programmers.problem31;

import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>(); 
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        map1 = InsertMap(str1, map1);
        map2 = InsertMap(str2, map2);

        if(map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }
        
        int intersection = 0;
        int total1 = 0;
        int total2 = 0;

        for(int i : map1.values()) {
            total1 += i;
        }
        for(int j : map2.values()) {
            total2 += j;
        }
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
        }
        int union = total1 + total2 - intersection;
        double jaccard = (double) intersection/union;
        answer = (int) (jaccard * 65536);

        return answer;
    }
    public Map<String,Integer> InsertMap(String str, Map<String, Integer> map) {
        StringBuilder st = new StringBuilder();
        for(int i = 0; i<str.length()-1; i++) {
            char c = str.charAt(i);
            char ch = str.charAt(i+1);
            if(c >= 'a' && c <= 'z' && ch >= 'a' && ch <= 'z') {
                st.append(c);
                st.append(ch);
                map.put(st.toString(), map.getOrDefault(st.toString(), 0)+1);
                st.setLength(0);
            }
        }
        return map;
    }
}
public class problem31 {
    public static void main(String[] args) {
        String str1 = "handshake";
        String str2 = "shake hands";
        Solution sol = new Solution();
        System.out.println(sol.solution(str1, str2));
    }
}
