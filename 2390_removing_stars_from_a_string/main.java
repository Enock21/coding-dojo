//2390. Removing Stars From a String
//https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//Supondo que * não pode ser o primeiro elemento de s
class Solution {
    public static String removeStars(String s) {
        char[] chars = s.toCharArray();
        String result = "";
        int i = 0;
        int j = 1;
        while(i < s.length()){
            if (j < s.length()){
                if (chars[j] == '*'){
                    i++;
                    j++;
                    continue;
                }
                result = result + chars[i];
            }else{
                result = result + chars[i];
            }
            i++;
            j++;
        }
        return result; 
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(Solution.removeStars("leet**cod*e"));
    }
}