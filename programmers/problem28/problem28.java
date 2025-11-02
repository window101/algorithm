package programmers.problem28;

import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int t : topping) {
            map.put(t, map.getOrDefault(t, 0)   + 1);
        }
        for(int i = 0; i<topping.length -1; i++) {
            int t = topping[i];
            set.add(t);
            map.put(t, map.get(t) - 1);
            if(map.get(t) == 0) {
                map.remove(t);
            }
            if(set.size() == map.size()) {
                answer++;
            }
        }
        return answer;
    }
}
public class problem28 {
    public static void main(String[] args) {
        int [] topping = new int[] {1, 2, 1, 3, 1, 4, 1, 2};
        Solution sol = new Solution();
        System.out.println(sol.solution(topping));
    }
}
