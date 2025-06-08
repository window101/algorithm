package programmers.vowelDictionary;

class Solution {
    static boolean found = false;
    static int answer = 0;
    static String[] vowel = new String[]{"A", "E", "I", "O", "U"};
    public int solution(String word) {
        
        dfs(0, new StringBuilder(), word);
        return answer;
    }
    public static void dfs(int depth, StringBuilder sb, String word) {
        if(found) {
            return;
        }
        if(depth > 5) {
            return;
        }
        if(sb.toString().equals(word)) {
            found = true;
            return;
        }
        answer++;
        for(int i = 0; i<vowel.length; i++) {
            sb.append(vowel[i]);
            dfs(depth+1, sb, word);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

public class vowelDictionary {
    public static void main(String[] args) {
        String word = "EIO";
        Solution sol = new Solution();
        System.out.println(sol.solution(word));
    }
}
