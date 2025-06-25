//2390. Removing Stars From a String
//https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

//Usando StringBuilder pra fazer operação em string
class Solution2 {
    public static String removeStars(String s) {
        StringBuilder str = new StringBuilder(s);

        int i = 0;
        while(i < str.length()){
            if (str.charAt(i) == '*'){
                str.deleteCharAt(i);//Fonte principal do delay
                str.deleteCharAt(i-1);//Fonte principal do delay
                i--;
                continue;
            }
            i++;
        }

        return str.toString();
    }
}

//Eliminando um dos deleteCharAt IOB????
class Solution3 {
    public static String removeStars(String s) {
        StringBuilder str = new StringBuilder(s);

        int i = 0;
        while(i < str.length()){
            if (str.charAt(i) == '*'){
                str.delete(i-1, i);
                i--;
                continue;
            }
            i++;
        }

        return str.toString();
    }
}

//Aplicando estrutura de stack
class Solution4 {
    public static String removeStars(String s) {

        Stack<Character> stk = new Stack<>();

        int i = 0;
        while(i < s.length()){
            if (s.charAt(i) == '*'){
                stk.pop();
            }else{
                stk.add(s.charAt(i));
            }
            i++;
        }

        StringBuilder result = new StringBuilder();

        while (stk.size() > 0){
            Character tst = stk.pop();
            result.append(tst);
        }
        result.reverse();

        return result.toString();
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(Solution4.removeStars("leet**cod*e"));
        /*
        Input: s = "leet**cod*e"
        Output: "lecoe"
         */
    }
}