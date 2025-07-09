package programmers.problem8;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCnt = 0;
        for(int i = 0; i<lottos.length; i++) {
            if(lottos[i] == 0) {
                zeroCnt++;
            }
            for(int j = 0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    count++;
                    break;
                }
            }
        }
        int max_num = count + zeroCnt;
        int min_num = count;
        answer[0] = getRate(max_num);
        answer[1] = getRate(min_num);
        return answer;
    }
    private int getRate(int n) {
        int res = -1;
        if(n == 6) {
            res = 1;
        }else if(n == 5) {
            res = 2;
        }else if(n == 4) {
            res = 3;
        }else if(n == 3) {
            res = 4;
        }else if(n == 2) {
            res = 5;
        }else {
            res = 6;
        }
        return res;
    }
}
public class problem8 {
    public static void main(String[] args) {
        int [] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int [] win_nums = new int[] {31, 10, 45, 1, 6, 19};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(lottos, win_nums)));
    }
}
