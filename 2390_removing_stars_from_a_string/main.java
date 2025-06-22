//2390. Removing Stars From a String
//https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//Supondo que * não pode ser o primeiro elemento de s
class Solution1 {
    public static String removeStars(String s) {
        ArrayList<Character> chars = new ArrayList<>();

        for (int i = 0; i < s.length(); i++){
            chars.add(s.charAt(i));
        }

        int i = 0;
        while(i < chars.size()){
            if (chars.get(i) == '*'){
                chars.remove(i);
                chars.remove(i-1);
                i--;
                continue;
            }
            i++;
        }

        String result = "";
        for (int j = 0; j < chars.size(); j++){
            result = result + chars.get(j);
        }
        return result;
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(Solution1.removeStars("leet**cod*e"));
        /*
        Input: s = "leet**cod*e"
        Output: "lecoe"
         */
    }
}