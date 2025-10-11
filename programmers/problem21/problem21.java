package programmers.problem21;

import java.util.*;
class Solution {
    public String solution(String input_string) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char prev = 0;

        for(char ch : input_string.toCharArray()) {
            if(sb.length() == 0 || ch == prev) {
                sb.append(ch);
            }else {
                list.add(sb.toString());
                sb.setLength(0);
                sb.append(ch);
            }
            prev = ch;
        }
        if(sb.length() > 0) list.add(sb.toString());
        Map<Character, Integer> countMap = new HashMap<>();
        for(String s : list) {
            char key = s.charAt(0);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        List<Character> answer = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() >= 2) {
                answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);
        if(answer.size() == 0) return "N";
        StringBuilder result = new StringBuilder();
        for(char c : answer) {
            result.append(c);
        }
        return result.toString();
    }
}
public class problem21 {
    public static void main(String[] args) {
        String input_string = "edeaaabbccd";
        Solution sol = new Solution();
        System.out.println(sol.solution(input_string));
    }
}
