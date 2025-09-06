package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private static void combine(char[] ch, int len, int start, StringBuilder sb, Map<String,Integer> map) {
        if(sb.length() == len) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) +1);
            return;
        }
        for(int i = start; i<ch.length; i++) {
            sb.append(ch[i]);
            combine(ch, len, i+1, sb, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        
        List<String> answerList = new ArrayList<>();
        for(int c : course) { // 2,3,4
            Map<String, Integer> map = new HashMap<>();
            for(String order : orders) {
                char [] ch = order.toCharArray();
                Arrays.sort(ch);
                combine(ch, c, 0, new StringBuilder(), map);
            }
            int max_cnt = 2;
            for(int cnt : map.values()) {
                if(cnt > max_cnt) {
                    max_cnt = cnt;
                }
            }
            for(Map.Entry<String,Integer> entry : map.entrySet() ) {
                if(entry.getValue() == max_cnt && entry.getKey().length() >=2) {
                    answerList.add(entry.getKey());
                }
            }
        }
        Collections.sort(answerList);
        return answerList.toArray(new String[answerList.size()]);
    }
}

public class MenuRenewal {
    public static void main(String[] args) {
        
        String orders[] = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int course[] = new int[] {2,3,4};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(orders, course)));

    }
}
