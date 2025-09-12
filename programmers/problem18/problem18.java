package programmers.problem18;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);
        for(int i = 1; i<arr.length; i++) {
            int tmp = Integer.parseInt(arr[i]);
            if(min > tmp) {
                min = tmp;
            }
            if(max < tmp) {
                max = tmp;
            }
        }
        return min + " " + max;
    }
}
public class problem18 {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
}
