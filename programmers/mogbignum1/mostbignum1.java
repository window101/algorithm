package programmers.mogbignum1;


import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        if(arr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
public class mostbignum1 {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 30, 34, 5, 9};
        Solution sol =  new Solution();
        System.out.println(sol.solution(numbers));
    }
}
