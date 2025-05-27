/*
 * https://leetcode.com/problems/roman-to-integer/description/?envType=problem-list-v2&envId=string
 */

class Solution1 {
    public static int romanToInt(String s) {
        Integer result = 0;
        String aux = "";
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (aux == "I"){
                if (c == 'V'){result += 4;}
                else if(c == 'X'){result += 9;}
                else{
                    result++;
                    aux = "";
                }
            }

            if (aux == "X"){
                if (c == 'L'){result += 40;}
                else if(c == 'C'){result += 90;}
                else{
                    result+=10;
                    aux = "";
                }
            }

            if (aux == "C"){
                if(c == 'D'){result += 400;}
                else if(c == 'M'){result += 900;}
                else{
                    result+=100;
                    aux = "";
                }
            }

            if (c == 'I'){
                aux = "I";
            };
            if (c == 'V'){result+=5;};
            if (c == 'X'){
                aux = "X";
            };
            if (c == 'L'){result+=50;};
            if (c == 'C'){
                aux = "C";
            };
            if (c == 'D'){result+=500;};
            if (c == 'M'){result+=1000;};
        }
        return result;
    }
}

class Solution2 {
    public static Integer romanToInt(String s){
        Integer result = 0;
        for (int i = 0; i < s.length(); i++){
            char c1 = 'a';
            char c2 = 'a';
            
            int currentNum = -1;
            int nextNum = -2;

            c1 = s.charAt(i);
            if (i < s.length() - 1) c2 = s.charAt(i+1);

            currentNum = charToNum(c1);
            if (i < s.length() - 1) nextNum = charToNum(c2);

            if (currentNum < nextNum) {
                result = result - currentNum;
            }else{
                result = result + currentNum;
            }
        }

        return result;
    }

    public static int charToNum(char c){
        if (c == 'I'){return 1;}
        else if (c == 'V'){return 5;}
        else if (c == 'X'){return 10;}
        else if (c == 'L'){return 50;}
        else if (c == 'C'){return 100;}
        else if (c == 'D'){return 500;}
        else if (c == 'M'){return 1000;}
        else return -1;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Solution2.romanToInt("IV"));
    }
}