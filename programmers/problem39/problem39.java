package programmers.problem39;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int m = q.length;
        int cnt = 0;
        int[] arr = new int[m];
        for(int i = 0; i<m; i++) {
            int mask = 0;
            for(int j = 0; j<5; j++) {
                mask |= 1 << (q[i][j] - 1);
            }
            arr[i] = mask;
        }
        for(int a = 1; a<=n-4; a++) {
            for(int b = a+1; b<=n-3; b++) {
                for(int c = b+1; c<=n-2; c++) {
                    for(int d = c+1; d<=n-1; d++) {
                        for(int e = d+1; e<=n; e++) {
                            int se_mask = 0;
                            se_mask |= 1 << (a-1);
                            se_mask |= 1 << (b-1);
                            se_mask |= 1 << (c-1);
                            se_mask |= 1 << (d-1);
                            se_mask |= 1 << (e-1);
                            boolean check = true;
                            for(int i = 0; i<m; i++) {
                                int common = Integer.bitCount(arr[i] & se_mask);
                                if(common != ans[i]) {
                                    check = false;
                                    break;
                                }
                            }
                            if(check) {
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
public class problem39 {
    public static void main(String[] args) {
        int n = 10;
        int[][] q = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = new int[] {2, 3, 4, 3, 3};
        Solution sol = new Solution();
        System.out.println(sol.solution(n, q, ans));
    }
}
