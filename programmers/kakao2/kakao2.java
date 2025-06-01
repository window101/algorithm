package programmers.kakao2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        
        for(String i : info) {
            String [] arr = i.split(" ");
            combination(arr, "", 0);
        }
        for(List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        int [] answer = new int[query.length];
        int cnt = 0;
        for(String q : query) {
            String [] arr2 = q.split(" and "); 
            int coding = Integer.parseInt(arr2[3].split(" ")[1]);
            arr2[3] = arr2[3].split(" ")[0];
            String key = String.join(" ", arr2);
            if(map.containsKey(key)) {
                int size = map.get(key).size();
                List<Integer> list = map.get(key);
                int indx = binarySearch(0, coding, list);
                answer[cnt] = size - indx;
            }
            cnt++;
            
        }

        return answer;
    }
    private int binarySearch(int start, int coding, List<Integer> list) {
        int left = start;
        int right = list.size();
        while(left < right) {
            int mid = (left+right)/2;
            if(list.get(mid) < coding) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    private void combination(String[] arr, String str, int depth) {
        if(depth == 4) {
            map.computeIfAbsent(str.trim(), k-> new ArrayList<>()).add(Integer.parseInt(arr[4]));
            return;
        }
        combination(arr, str + arr[depth] + " ", depth+1);
        combination(arr, str + "- " , depth+1);
    }
}

public class kakao2 {
    public static void main(String[] args) {
        String [] info = new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150",
                        "cpp backend senior pizza 260","java backend junior chicken 80",
                        "python backend senior chicken 50"};
        String [] query = new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250","- and backend and senior and - 150",
                        "- and - and - and chicken 100","- and - and - and - 150"};

        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(info, query)));
    }

}
