package programmers.problem26;

import java.util.*;
class Solution {
    static class Stage implements Comparable<Stage>{
        int stageNumber;
        double failRate;

        Stage(int stageNumber, double failRate) {
            this.stageNumber = stageNumber;
            this.failRate = failRate;
        }
        @Override
        public int compareTo(Stage other) {
            if(this.failRate != other.failRate) {
                return Double.compare(other.failRate, this.failRate);
            }
            return Integer.compare(this.stageNumber, other.stageNumber);
        }
        
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stagePerson = new int[N+2];
        Double[] stageFailRate = new Double[N+2];
        //int cnt = 0;
        for(int i = 0; i<stages.length; i++) {
            stagePerson[stages[i]]++;
        }
        int totalPerson = stages.length;
        for(int i = 1; i<=N; i++) {
            if(stagePerson[i] == 0) {
                stageFailRate[i] = 0.0;
            }else {
                stageFailRate[i] = (double)stagePerson[i] / totalPerson;
            }
            totalPerson -= stagePerson[i];
        }
        Stage[] stageArr = new Stage[N+1];
        for(int i = 1; i<=N; i++) {
            stageArr[i] = new Stage(i, stageFailRate[i]);
        }
        Arrays.sort(stageArr, 1, N+1);
        for(int i = 1; i<=N; i++) {
            answer[i-1] = stageArr[i].stageNumber;
        }
        return answer;
    }
}
public class problem26 {
    public static void main(String[] args) {
        int N = 5;
        int [] stages = new int[] {2,1,2,6,2,4,3,3};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(N, stages)));
    }
}
