package programmers.problem12;
import java.util.*;

class Solution {
    static class Analysis {
        int code;
        int date;
        int maximum;
        int remain;
        private Analysis(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
        private int[] toArray() { // 객체를 int[]로 변환
            return new int[]{code, date, maximum, remain};
        }
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Analysis> list = new ArrayList<>();
        for(int[] d : data) {
            int value = Calculator(d, ext);
            if(value < val_ext) {
                list.add(new Analysis(d[0], d[1], d[2], d[3]));
            }
        }
        list.sort((a,b) -> {
            int valA = Calculator(new int[]{a.code, a.date, a.maximum, a.remain}, sort_by);
            int valB = Calculator(new int[]{b.code, b.date, b.maximum, b.remain}, sort_by);
            return Integer.compare(valA, valB);
        });
        int [][] answer = new int[list.size()][];
        for(int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i).toArray();
        }
        return answer;
    }
    private int Calculator(int[] arr, String key) {
        if(key.equals("code")) {
            return arr[0];
        }else if(key.equals("date")) {
            return arr[1];
        }else if(key.equals("maximum")) {
            return arr[2];
        }else {
            return arr[3];
        }
    }
}
public class problem12 {
    public static void main(String[] args) {
        int [][] data = new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.solution(data, ext, val_ext, sort_by)));
    }
}
