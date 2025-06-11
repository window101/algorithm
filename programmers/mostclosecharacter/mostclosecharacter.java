package programmers.mostclosecharacter;


import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                answer[i] = -1;
                map.put(ch, i);
            }else {
                int diff = i - map.get(ch);
                answer[i] = diff;
                map.put(ch, i);
            }
        }
        return answer;
    }
}
public class mostclosecharacter {
    public static void main(String[] args) {
        String s = "banana";
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(s)));
    }
}
