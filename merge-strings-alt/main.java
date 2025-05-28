//https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75

class Solution1 {
    public static String mergeAlternately(String word1, String word2) {
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
                /* Problema de eficiência:
                    Strings em Java são imutáveis.

                    Toda vez que você faz result + something, você está criando uma nova String.

                    Isso exige:

                    Alocar novo espaço na memória

                    Copiar o conteúdo da String anterior

                    Acrescentar o novo caractere

                    🔁 Se você tiver n concatenações, você pode acabar fazendo até O(n²) operações de cópia!
                 */
            }else {
                result = result + word2.charAt(i);
            }
        }
        return result;
    }
}

class Solution2 {
    public static String mergeAlternately(String word1, String word2) {
        int minLength = 0;
        int maxLength = 0;
        StringBuilder result = new StringBuilder();
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
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        for (int i = minLength; i < maxLength; i++){
            if (!word2Bigger){
                result.append(word1.charAt(i));
                
            }else {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
}

class Main {
    public static void main(String[] args){
        System.out.println(Solution2.mergeAlternately("abcdefg", "null"));
    }
}
