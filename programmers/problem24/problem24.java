package programmers.problem24;

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] f_answer = new int[] {1,2,3,4,5};
        int[] s_answer = new int[] {2,1,2,3,2,4,2,5};
        int[] t_answer = new int[] {3,3,1,1,2,2,4,4,5,5};
        int f_indx = 0; int f_cnt = 0;
        int s_indx = 0; int s_cnt = 0;
        int t_indx = 0; int t_cnt = 0;
        
        for(int i = 0; i<answers.length; i++) {
            if(f_answer[f_indx] == answers[i]) f_cnt++;
            if(s_answer[s_indx] == answers[i]) s_cnt++;
            if(t_answer[t_indx] == answers[i]) t_cnt++;
            f_indx++; s_indx++; t_indx++;
            if(f_indx == f_answer.length) f_indx = 0;
            if(s_indx == s_answer.length) s_indx = 0;
            if(t_indx == t_answer.length) t_indx = 0;
        }
        int max = Math.max(f_cnt, Math.max(s_cnt, t_cnt));
        if(f_cnt == max) list.add(1);
        if(s_cnt == max) list.add(2);
        if(t_cnt == max) list.add(3);

        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
public class problem24 {
    public static void main(String[] args) {
        int[] answers = new int[] {1,3,2,4,2};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(answers)));
    }
}
