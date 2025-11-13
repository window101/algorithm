package programmers.problem30;

import java.util.*;

class Solution {
    static class Task {
        int score;
        int arrival;
        int run;
        Task(int score, int arrival, int run) {
            this.score = score;
            this.arrival = arrival;
            this.run = run;
        }
    }
    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        long t = 0L;
        int i = 0;
        int n = program.length;
        Task[] arr = new Task[n];
        for(int s = 0; s<n; s++) {
            int a = program[s][0];
            int b = program[s][1];
            int c = program[s][2];
            arr[s] = new Task(a,b,c);
        }
        Arrays.sort(arr, (x,y) -> {
            if(x.arrival != y.arrival) return Integer.compare(x.arrival, y.arrival);
            if(x.score != y.score) return Integer.compare(x.score, y.score);
            return Integer.compare(x.run, y.run);
        });
        PriorityQueue<Task> pq = new PriorityQueue<>((x,y) -> {
            if(x.score != y.score) return Integer.compare(x.score, y.score);
            return Integer.compare(x.arrival, y.arrival);
        });

        while(i < n || !pq.isEmpty()) {
            if(pq.isEmpty() && t < arr[i].arrival) {
                t = arr[i].arrival;
            }
            while(i < n && arr[i].arrival <= t) {
                pq.offer(arr[i++]);
            }
            Task cur = pq.poll();
            long wait = t - cur.arrival;
            answer[cur.score] += wait;
            t += cur.run;
        }
        answer[0] = t;
        return answer;
    }
}
public class problem30 {
    public static void main(String[] args) {
        int[][] program = new int[][] {{2,0,10}, {1,5,5}, {3,5,3}, {3,12,2}};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(program)));
    }
}
