package programmers.problem29;

import java.util.Arrays;
class Solution {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        for(int i = 0; i<queries.length; i++) {
            int n = queries[i][0];
            int p = queries[i][1];
            answer[i] = getGenotype(n,p);
        }    
        return answer;
    }
    private String getGenotype(int n, int p) {
        if(n == 1) {
            return "Rr";
        }
        int parentIdx = (p-1) / 4 + 1;
        int childIdx = (p-1) % 4;
        String parent = getGenotype(n-1, parentIdx);
        if(parent.equals("RR")) {
            return "RR";
        }
        if(parent.equals("rr")) {
            return "rr";
        }
        switch(childIdx) {
            case 0 : return "RR";
            case 1 :
            case 2 : return "Rr";
            default : return "rr";
        }
    }
}
public class problem29 {
    public static void main(String[] args) {
        int [][] queries = new int[][] {{3,8}, {2,2}};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(queries)));
    }
}
