package programmers.pokemon;

import java.util.HashSet;

public class pokemon {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for(int a : nums) {
            set.add(a);
        }
        if(set.size() > max) {
            answer = max;
        }else {
            answer = set.size();
        }
        return answer;
    }
}
