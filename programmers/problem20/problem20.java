package programmers.problem20;

import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        Map<String, Integer> map = new HashMap<>();
        makeMap(map);
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                sb.append(c);
                tmp = "";
            }else {
                tmp += c;
                if(map.containsKey(tmp)) {
                    sb.append(map.get(tmp));
                    tmp = "";
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }
    public void makeMap(Map<String, Integer> map) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }
}
public class problem20 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
}
