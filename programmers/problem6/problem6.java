package programmers.problem6;

import java.util.*;

class Solution {
    static class Stage {
        int stage;
        double failRate;

        Stage(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stagesPerson = new int[N+2];
        int totalPerson = stages.length;
        double[] failRate = new double[N+1];
        List<Stage> stageList = new ArrayList<>();

        for(int i = 0; i<totalPerson; i++) {
            stagesPerson[stages[i]]++;
        }
        int tmpPerson = totalPerson;
        for(int i = 1; i<=N; i++) {
            if(tmpPerson == 0) { // 도달한 유저가 없는경우
                failRate[i] = 0;
            }else {
                failRate[i] = (double) stagesPerson[i] / tmpPerson;
            }
            stageList.add(new Stage(i, failRate[i]));
            tmpPerson -= stagesPerson[i];
        }
        // failRate 내림차순, failRate가 같으면 stage 작은게 먼저
        stageList.sort((a,b) -> {
            if(Double.compare(b.failRate, a.failRate) != 0) {
                return Double.compare(b.failRate, a.failRate); // 내림차순
            }else {
                return Integer.compare(a.stage, b.stage); // 오름차순
            }
        });
        for(int i = 0; i<N; i++) {
            answer[i] = stageList.get(i).stage;
        }
        return answer;
    }
}

public class problem6 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(N, stages)));
    }
}
