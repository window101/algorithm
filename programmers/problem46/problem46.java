package programmers.problem46;

import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++) {
            map.put(friends[i], i);
        }
        int[][] gift = new int[n][n];
        int[] receive = new int[n];
        int[] give = new int[n];
        int[] score = new int[n];
        int[] next = new int[n];

        for(String s : gifts) {
            String[] parts = s.split(" ");
            String from = parts[0];
            String to = parts[1];
            int a = map.get(from);
            int b = map.get(to);
            gift[a][b]++;
            give[a]++;
            receive[b]++;
        }
        for(int i = 0; i<n; i++) {
            score[i] = give[i] - receive[i];
        }
        for(int i = 0; i<n; i++) { // n=4
            for(int j = i+1; j<n; j++) {
                if(i == j) {
                    continue;
                }
                // i : 준사람, j : 받은사람
                if(gift[i][j] > gift[j][i]) {
                    next[i]++;
                }else if(gift[i][j] < gift[j][i]) {
                    next[j]++;
                }else {
                    if(score[i] > score[j]) {
                        next[i]++;
                    }else if(score[i] < score[j]) {
                        next[j]++;
                    }
                }
            }
        }
        for(int i = 0; i<n; i++) {
            if(answer < next[i]) {
                answer = next[i];
            }
        }
        return answer;
    }
}
public class problem46 {
    public static void main(String[] args) {
        String[] friends = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        Solution sol = new Solution();
        System.out.println(sol.solution(friends, gifts));
    }
}
