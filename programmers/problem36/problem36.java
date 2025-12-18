package programmers.problem36;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[][] arr = new int[24][2]; // 행은 0~23시, 열[0]은 총서버수, 열[1]은 해당 시간 서버증설개수
        for(int i = 0; i<arr.length; i++) {
            if(i > 0) {
                arr[i][0] = arr[i-1][0];
            }
            if(i - k >= 0 && arr[i-k][1] > 0) {
                // 5시간이 지나고 k 시간전에 증설을 했으면
                arr[i][0] -= arr[i-k][1]; // 총서버수에서 해당 시간의 서버 증설 갯수를 차감
            }
            
            if(players[i] / m >= arr[i][0]) {
                arr[i][1] = players[i] / m - arr[i][0];
                arr[i][0] = players[i]/m;
            }
        }
        
        for(int i = 0; i<arr.length; i++) {
            if(arr[i][1] > 0) {
                answer += arr[i][1];
            }
        }
        return answer;
    }
}
public class problem36 {
    public static void main(String[] args) {
        int [] players = new int[] {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        Solution sol = new Solution();
        System.out.println(sol.solution(players, m, k));
    }
}
