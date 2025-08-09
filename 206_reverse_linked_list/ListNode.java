import java.util.ArrayList;
import java.util.Collections;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//Própria
class Solution{
    public static ListNode reverseList(ListNode node){
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            if (node == null){
                return null;
            }
            list.add(node.val);
            if (node.next == null){
                break;
            }
            node = node.next;
        }
        
        Collections.reverse(list);

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : list){
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}

//Alheia
class Solution2{
    public static ListNode reverseList(ListNode head) {

        ArrayList<Integer> vals = new ArrayList<Integer>();

        if (head == null) {
            return null;
        }

        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        System.out.println(vals.toString());

        ListNode n = new ListNode(vals.get(0), null);
        for (int i = 1; i < vals.size(); i++) {

            n = new ListNode(vals.get(i), n);
        }

        return n;   
    }
}

//Mais otimizada. Própria
class Solution3{
    public static ListNode reverseList(ListNode head){
        if(head == null){return null;}
        if(head.next == null){return head;}

        ListNode tail = new ListNode(head.val);
        head = head.next;
        while(true){
            tail = new ListNode(head.val, tail);
            if (head.next == null){break;}
            head = head.next;
        }

        return tail;
    }
}

//Recursiva. GPT
class Solution4{
    public static ListNode reverseList(ListNode head) {
        // Caso base: lista vazia ou um único nó
        if (head == null || head.next == null) {
            return head;
        }

        // Inverte recursivamente a sublista que começa em head.next
        ListNode newHead = reverseList(head.next);

        // Depois que a sublista estiver invertida,
        // head.next é o último nó da sublista invertida original.
        head.next.next = head; // faz o próximo apontar para head (inverte a ligação)
        head.next = null;      // evita ciclo, head vira o final da lista

        return newHead; // newHead é a nova cabeça (antigo último nó)
    }
}

//Solution4 alterada pra teste
class Solution5{
    public static ListNode reverseList(ListNode head) {
        // Caso base: lista vazia ou um único nó
        if (head == null || head.next == null) {
            return head;
        }

        // Inverte recursivamente a sublista que começa em head.next
        ListNode newHead = reverseList(head.next);

        // Depois que a sublista estiver invertida,
        // head.next é o último nó da sublista invertida original.
        newHead.next = head; //Alteração. Dá errado.
        head.next = null;      // evita ciclo, head vira o final da lista

        return newHead; // newHead é a nova cabeça (antigo último nó)
    }
}

//Solution 4 alterada pra teste
class Solution6{
    public static ListNode reverseList(ListNode head) {
        // Caso base: lista vazia ou um único nó
        if (head == null || head.next == null) {
            return head;
        }

        // Inverte recursivamente a sublista que começa em head.next
        ListNode newHead = reverseList(head.next);

        // Depois que a sublista estiver invertida,
        // head.next é o último nó da sublista invertida original.
        head.next.next = head; // faz o próximo apontar para head (inverte a ligação)
        //head.next = null;      // evita ciclo, head vira o final da lista
        //Alteração acima

        return newHead; // newHead é a nova cabeça (antigo último nó)
    }
}

//Refazendo a solucao recursiva sem olhar a resposta
class Solution7{
    public static ListNode reverseList(ListNode currentNode){
        if (currentNode == null || currentNode.next == null){
            return currentNode;
        }

        ListNode newHead = reverseList(currentNode.next);

        currentNode.next.next = currentNode;

        currentNode.next = null;

        return newHead;
    }
}

class Main{
    public static void main(String[] args){
        ListNode node = new ListNode(
            1, new ListNode(
                2, new ListNode(
                    3, new ListNode(
                        4, new ListNode(5)
                    )
                )
            )
        );

        node = Solution7.reverseList(node);
        
        while(true){
            if (node == null){break;}
            System.out.println(node.val);
            if (node.next == null){
                break;
            }
            node = node.next;
        }
    }
}