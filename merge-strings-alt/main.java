//https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    class Solution {
    public String mergeAlternately(String word1, String word2) {
        int minLength = 0;
        int maxLength = 0;
        String result = "";
        boolean word2Bigger = false;
        if (word1.length() <= word2.length()){
            minLength = word1.length();
            maxLength = word2.length();
            word2Bigger = true;
        }
        else{
            minLength = word2.length();
            maxLength = word1.length();
        }
        for (int i = 0; i < minLength; i++){
            result = result + word1.charAt(i);
            result = result + word2.charAt(i);
        }
        for (int i = minLength; i < maxLength; i++){
            if (!word2Bigger){
                result = result + word1.charAt(i);
            }else {
                result = result + word2.charAt(i);
            }
        }
        return result;
    }
}
}

class Main {
    public static void main(String[] args){
        System.out.println(Solution.mergeAlternately("abcdefg", "null"));
    }
}
