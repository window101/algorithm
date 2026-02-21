package programmers.problem45;

class Solution {
    private int toHourMinutes(int i_time) {
        int h = i_time / 100;
        int m = i_time % 100;
        return h*60+m;
    }
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i<timelogs.length; i++) {
            boolean check = false;
            int st_day = startday;
            for(int j = 0; j<timelogs[0].length; j++) {
                // if(j > (st_day-1)%7) {
                //     continue;
                // }
                
                if(st_day == 6 || st_day == 7) {
                    st_day++;
                    if(st_day == 8) {
                        st_day = 1;
                    }
                    continue;
                }
                if(toHourMinutes(schedules[i]) + 10 < toHourMinutes(timelogs[i][j])) {
                    check = true;
                    break;
                }
                st_day++;
            }
            if(!check) {
                answer++;
            }
        }
        return answer;
    }
}
public class problem45 {
    public static void main(String[] args) {
        int [] schedules = new int[] {700,800,1100};
        int [][] timelogs = new int[][] {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;
        Solution sol = new Solution();
        System.out.println(sol.solution(schedules, timelogs, startday));
    }
}
