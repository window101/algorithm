package programmers.problem38;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int n = diffs.length;
        int left = 1;
        int right = -1;
        for(int i = 0; i<n; i++) {
            if(right < diffs[i]) {
                right = diffs[i];
            }
        }
        while(left < right) {
            int mid = (left + right) / 2;
            if(findMinSkill(diffs, times, limit, mid)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean findMinSkill(int[] diffs, int[] times, long limit, int mid) {
        long total_time = 0L;
        for(int i = 0; i<diffs.length; i++) {
            
            long time_cur = times[i]; // 현재 diff 소요시간
            long time_prev;
            if(i > 0) {
                time_prev = times[i-1];
            }else {
                time_prev = 0L;
            }
            int diff = diffs[i]; // 현재 난이도
            long fail_cnt = Math.max(0, diff-mid);
            total_time += time_cur + fail_cnt * (time_cur + time_prev);
            if(total_time > limit) {
                return false;
            }  
        }
        return true;
    }
}
public class problem38 {
    public static void main(String[] args) {
        int [] diffs = new int[] {1,5,3};
        int [] times = new int[] {2,4,7};
        int limit = 30;
        Solution sol = new Solution();
        System.out.println(sol.solution(diffs, times, limit));
    }
}
