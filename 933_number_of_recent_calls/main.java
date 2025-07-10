import java.util.LinkedList;

//Solução com bug. Toda vez que o head da fila muda de valor, existe a possibilidade de que a quantidade de ms que se passou entre a chamada atual e aquela que se encontra no começo da fila (head) resulte em um valor maior que 3000. Neste caso, o valor de head precise ser modificado novamente até que o intervalo de ms entre tail e head seja menor ou igual a 3000ms. O código abaixo desconsidera esse caso, causando um bug em certas entradas no qual ele não conta a quantidade correta de pings nos ultimos 3000ms.
class RecentCounter1{
    LinkedList<Integer> pings;
    int count;

    final int timeLimit = 3000;

    public RecentCounter1(){
        this.pings = new LinkedList<>();
        this.count = 0;
    }

    public int ping(int t){
        pings.add(t);
        if(pings.getLast() - pings.getFirst() > timeLimit){
            count = 1;
            pings.removeFirst();
        }else{
            count++;
        }

        return count;
    }
}

//Correção do bug da solução anterior.
//Percebi que o count era desnecessário e resultava em bug do jeito que estava sendo usado. Era só retornar a quantidade atual de pings no vetor.
//Solução entre as mais otimizadas no leetcode.
class RecentCounter2{
    LinkedList<Integer> pings;

    final int timeLimit = 3000;

    public RecentCounter2(){
        this.pings = new LinkedList<>();
    }

    public int ping(int t){
        pings.add(t);
        int msPassed = pings.getLast() - pings.getFirst();
        if(msPassed > timeLimit){
            while(msPassed > timeLimit){
                pings.removeFirst();
                msPassed = pings.getLast() - pings.getFirst();
            }
        }

        return this.pings.size();
    }
}

class Main{
    public static void main(String[] args){
        RecentCounter2 rc = new RecentCounter2();

        System.out.println(rc.ping(642));
        System.out.println(rc.ping(1849));
        System.out.println(rc.ping(4921));
        System.out.println(rc.ping(5936));
        System.out.println(rc.ping(5957));

        // System.out.println(rc.ping(1));
        // System.out.println(rc.ping(100));
        // System.out.println(rc.ping(3001));
        // System.out.println(rc.ping(3002));
    }
}