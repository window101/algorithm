package programmers.problem34;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videolen = toSec(video_len);
        int cur = toSec(pos);
        int start = toSec(op_start);
        int end = toSec(op_end);

        if(cur >= start && cur <= end) {
            cur = end;
        }
        for(int i = 0; i<commands.length; i++) {
            // if(cur >= start && cur <= end) {
            //     cur = end;
            // }
            if(commands[i].equals("prev")) {
                if(cur <= 10) {
                    cur = 0;
                    continue;
                }
                cur = cur - 10;
            }else if(commands[i].equals("next")) {
                if(videolen - 10 <= cur) {
                    cur = videolen;
                    continue;
                }
                cur = cur + 10;
            }
            if(cur >= start && cur <= end) {
                cur = end;
            }
        }
        String answer = toMMSS(cur);
        return answer;
    }
    public int toSec(String str) {
        int hour = Integer.parseInt(str.split(":")[0]);
        int minute = Integer.parseInt(str.split(":")[1]);
        return hour*60+minute;
    }
    public String toMMSS(int cur) {
        int m = cur / 60;
        int s = cur % 60;
        return String.format("%02d:%02d", m, s);
    }
}
public class problem34 {
    public static void main(String[] args) {
        String video_len = "34:33";
        String pos = "13:00";
        String op_start = "00:55";
        String op_end = "02:55";
        String[] commands = new String[]{"next", "prev"};
        Solution sol = new Solution();
        System.out.println(sol.solution(video_len, pos, op_start, op_end, commands));
    }
}
