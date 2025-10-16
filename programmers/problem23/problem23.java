package programmers.problem23;

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<numbers.length; i++) {
            for(int j = i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        for(int num : set) {
            list.add(num);
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

public class problem23 {
    public static void main(String[] args) {
        int[] numbers = new int[] {2,1,3,4,1};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(numbers)));
    }
}
