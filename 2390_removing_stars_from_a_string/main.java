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

//Eliminando um dos deleteCharAt, corta o tempo pela metade.
class Solution3 {
    public static String removeStars(String s) {
        StringBuilder str = new StringBuilder(s);

        int i = 0;
        while(i < str.length()){
            Character character = str.charAt(i);
            if (character == '*'){
                str.delete(i-1, i+1);
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

//Trocando Stack por StringBuilder na solução 4 pra tentar provar minha hipótese de que o .pop do stack é mais otimizado do que o deleteCharAt() do StringBuilder
//Foi mais eficiente do que a solucao 5. Afinal o deleteCharAt() não é mais custoso que o pop()? Ou o custo da nova solução compensa o overhead adicional do deletCharAt()?
//Resposta: O deleteCharAt acessa elementos em tempo constante. O que custa é alterar o array pra preencher a lacuna do elemento removido. Quando se remove o ultimo elemento com deleteCharAt, não há custo de movimentação, tornado-a uma operação O(1).
class Solution5 {
    public static String removeStars(String s) {

        StringBuilder stk = new StringBuilder();

        int i = 0;
        while(i < s.length()){
            if (s.charAt(i) == '*'){
                stk.deleteCharAt(stk.length()-1);
            }else{
                stk.append(s.charAt(i));
            }
            i++;
        }

        return stk.toString();
    }
}

//Versão mais otimizada, gerada pelo chatGPT.

//Iterar em um array de chars é mais eficiente do que iterar em uma string?
//R: sim. É mais rapido de acessar sequencialmente (acesso direto em memória).

//charAt() da String pode custar. Remover isso é bom.

//For each pode ser levemente melhor que o while.

//Chamar o charAt multiplas vezes não é bom. Melhor chamar uma vez e guardar o valor em uma variável.
class Solucao6{
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1); // remove o último char
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

//Levemente mais otimizada (93.10% no leetcode). Gerada por IA.
class Solution7{
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder(s.length()); // setar o length de sb permite usar o .setLength depois, mais rapido q deleteCharAt()

        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.setLength(sb.length() - 1); // mais rápido que deleteCharAt()
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

//Solução 100% no leetcode. Não minha.

//PONTOS DE OTIMIZAÇÃO
//1. Uso de um array de char ao invés de stringbuilder.
//2. Pré aquecimento do JIT compiler. Pequena trapaça técnica. Inútil em produção.
class Solution8 {
    static{
        for(int i=0; i<200; i++){
            removeStars("");
        }
    }
    static final char STAR = '*';
    public static String removeStars(String s) {
        char[] c = s.toCharArray();
        int idx = 0;
       
       for(char ch:c){
            if(ch == STAR) idx--;
            else c[idx++]=ch;
       }

       return new String(c, 0, idx);
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(Solution5.removeStars("leet**cod*e"));
        /*
        Input: s = "leet**cod*e"
        Output: "lecoe"
         */
    }
}