package programmers.reapply;

class Solution {
    public int solution(int n, int m, int[] section) {
     
        int answer = 0;
        int indx = 0;
        
        while(indx < section.length) {
            int s = section[indx];
            int e = s + m - 1;
            answer++;
            while(section[indx] <= e && indx < section.length) {
                indx++;
            }
        }
        return answer;

    }
        
}
public class reapply {
    public static void main(String[] args) {

        int n = 8;
        int m = 4;
        int [] section = new int[] {2,3,6};
        Solution sol = new Solution();
        System.out.println(sol.solution(n,m,section));

    }
}
