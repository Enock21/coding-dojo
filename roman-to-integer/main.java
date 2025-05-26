class Solution {
    public static int romanToInt(String s) {
        Integer result = 0;
        String aux = "";
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'I'){
                if (aux == ""){aux = aux + 'I';};
                else{result++;};
            };
            if (s.charAt(i) == 'V'){
                if (aux == "I"){
                    result+=4;
                    aux = "";
                }else {result+=5};
            };
            if (s.charAt(i) == 'X'){result+=10;};
            if (s.charAt(i) == 'L'){result+=50;};
            if (s.charAt(i) == 'C'){result+=100;};
            if (s.charAt(i) == 'D'){result+=500;};
            if (s.charAt(i) == 'M'){result+=1000;};
        }
        return result;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Solution.romanToInt("XVIII"));
    }
}