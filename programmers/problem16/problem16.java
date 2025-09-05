package programmers.problem16;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int a : arr) {
            answer+=a;
        }
        answer = answer/arr.length;
        return answer;
    }
}
public class problem16 {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4};
        Solution sol = new Solution();
        System.out.println(sol.solution(arr));
    }
}
