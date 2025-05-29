package programmers.kakao1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> map = new HashMap<>(); // 신고당한아이디 : 신고당한횟수 ex.. {frodo : 2, neo : 2, muzi : 1}
        Set<String> recordSet = new HashSet<>(Arrays.asList(report)); // report 중복제거
        Map<String, Integer> map2 = new HashMap<>(); // 유저별 이메일 받은 횟수 , Hashmap은 순서보장 안함

        for(String user : id_list) {
            map2.put(user, 0);
        }
        for(String c : recordSet) {
            String[] arr = c.split(" ");
            String reporter = arr[0];
            String criminal = arr[1];
            map.put(criminal, map.getOrDefault(criminal, 0) + 1) ;
        }
        for(String c : recordSet) {
            String[] arr = c.split(" ");
            String reporter = arr[0]; // 신고한 사람
            String criminal = arr[1]; // 신고당한 사람
            if(map2.containsKey(reporter) && map.get(criminal) >= k) {
                map2.put(reporter, map2.getOrDefault(reporter, 0) + 1);
            }
        }
        for(int i= 0 ; i<id_list.length; i++) {
            answer[i] = map2.get(id_list[i]);
        }
        return answer;
    }
}
public class Kakao1 {
    public static void main(String[] args) {
        
        String [] id_list = new String[] {"muzi", "frodo", "apeach", "neo"};
        String [] report = new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(id_list, report, k)));

    }
    
}
