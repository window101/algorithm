package programmers.problem37;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] arr = new boolean[10];
        for(int i = 0; i<numbers.length; i++) {
            arr[numbers[i]] = true;
        }
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == false) {
                answer += i;
            }
        }
        return answer;
    }
}
public class problem37 {
    public static void main(String[] args) {
        int [] numbers = new int[] {1,2,3,4,6,7,8,0};
        Solution sol = new Solution();
        System.out.println(sol.solution(numbers));
    }
}
