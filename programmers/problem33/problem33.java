package programmers.problem33;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] isLost = new boolean[n+1];
        boolean[] hasReserve = new boolean[n+1]; // 겹침(도둑받은게 2번인데, 여분에 2번있는경우)

        for(int i=0; i<lost.length; i++) {
            isLost[lost[i]] = true;
        }
        for(int i = 0; i<reserve.length; i++) {
            hasReserve[reserve[i]] = true;
        }
        for(int i = 1; i<=n; i++) {
            if(isLost[i] && hasReserve[i]) {
                isLost[i] = false;
                hasReserve[i] = false;
            }
        }
        for(int i = 1; i<=n; i++) {
            if(isLost[i]) {
                if(hasReserve[i-1]) {
                    isLost[i] = false;
                    hasReserve[i-1] = false;
                }else if(i+1 <=n && hasReserve[i+1]) {
                    isLost[i] = false;
                    hasReserve[i+1] = false;
                }
            }
        }
        int answer = 0;
        for(int i = 1; i<=n; i++) {
            if(!isLost[i]) {
                answer++;
            }
        }
        return answer;
    }
}
public class problem33 {
    public static void main(String[] args) {
        int n = 5;
        int [] lost = new int[]{2,4};
        int [] reserve = new int[] {1,3,5};
        Solution sol = new Solution();
        System.out.println(sol.solution(n, lost, reserve));
    }
}
// int cnt = reserve.length;
        // boolean[] arr = new boolean[n+1]; // true면 잃어버린 사람
        // Arrays.sort(lost);
        // Arrays.sort(reserve);
        

        // for(int i = 0; i<lost.length; i++) {
        //     arr[lost[i]] = true;
        // }
        // for(int i = 0; i<reserve.length; i++) {
        //     if(i+1> lost.length) break;
        //     if(reserve[i] -1 == lost[i] || reserve[i] +1 == lost[i] ) {
        //         arr[lost[i]] = false;
        //         reserve[i] = -10000;
        //     }
        // }
        // int answer = 0;
        // for(int i = 1; i<=n; i++) {
        //     if(!arr[i]) {
        //         answer++;
        //     }
        //  }
        //  return answer;