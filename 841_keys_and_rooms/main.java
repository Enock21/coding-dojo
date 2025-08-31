import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Solution {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> roomsVisited = new ArrayList<>();
        List<Integer> keyStorage = new ArrayList<>();
        visitRoom(0, rooms.get(0), keyStorage, roomsVisited);
        while(!keyStorage.isEmpty()){
            Integer keyNumber = keyStorage.get(0);
            keyStorage.remove(0);
            visitRoom(keyNumber, rooms.get(keyNumber), keyStorage, roomsVisited);
        }
        if (roomsVisited.size() == rooms.size()) return true;
        else return false;
    }

    public static void visitRoom(Integer roomNumber, List<Integer> keysFound, List<Integer> keyStorage, List<Integer> roomsVisited){
        if (roomsVisited.contains(roomNumber)) return;
        roomsVisited.add(roomNumber);
        for (Integer key : keysFound){
            if (!keyStorage.contains(key)) keyStorage.add(key);
        }
    }
}

class Solution2 {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> roomsVisited = new HashSet<>();
        Set<Integer> keyStorage = new HashSet<>();
        visitRoom(0, rooms.get(0), keyStorage, roomsVisited);
        Iterator<Integer> keyStorageIterator = keyStorage.iterator(); // BUG:
        /**
         * Resulta em ConcurrentModificationException na segunda execução de keyStorageIterator.next(), pois o iterator detecta modificação na estrutura do keyStorage, resultado do addAll() em visitRoom. Uma solução é criar um novo Iterator a cada iteração do while, garantindo que o iterator não detecte modificação na estrutura do keyStorage e não lance a exceção.
         */
        while(!keyStorage.isEmpty()){
            Integer keyNumber = keyStorageIterator.next();
            keyStorageIterator.remove();
            visitRoom(keyNumber, rooms.get(keyNumber), keyStorage, roomsVisited);
        }
        if (roomsVisited.size() == rooms.size()) return true;
        else return false;
    }

    public static void visitRoom(Integer roomNumber, List<Integer> keysFound, Set<Integer> keyStorage, Set<Integer> roomsVisited){
        if (roomsVisited.contains(roomNumber)) return;
        roomsVisited.add(roomNumber);
        keyStorage.addAll(keysFound);
    }
}

//Aplicando HashSet em vez de ArrayList para otimização.
class Solution3 {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> roomsVisited = new HashSet<>();
        Set<Integer> keyStorage = new HashSet<>();
        visitRoom(0, rooms.get(0), keyStorage, roomsVisited);
        while(!keyStorage.isEmpty()){
            Iterator<Integer> keyStorageIterator = keyStorage.iterator();
            Integer keyNumber = keyStorageIterator.next();
            keyStorageIterator.remove();
            visitRoom(keyNumber, rooms.get(keyNumber), keyStorage, roomsVisited);
        }
        if (roomsVisited.size() == rooms.size()) return true;
        else return false;
    }

    public static void visitRoom(Integer roomNumber, List<Integer> keysFound, Set<Integer> keyStorage, Set<Integer> roomsVisited){
        if (roomsVisited.contains(roomNumber)) return;
        roomsVisited.add(roomNumber);
        keyStorage.addAll(keysFound);
    }
}

class Main{
    public static void main(String[] args){

        // List<List<Integer>> rooms = new ArrayList<>();
        // rooms.add(new ArrayList<>(Arrays.asList(1)));
        // rooms.add(new ArrayList<>(Arrays.asList(2)));
        // rooms.add(new ArrayList<>(Arrays.asList(3)));
        // rooms.add(new ArrayList<>(Arrays.asList()));

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(Arrays.asList(1,3)));
        rooms.add(new ArrayList<>(Arrays.asList(3,0,1)));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(Arrays.asList(0)));

        System.out.println(Solution3.canVisitAllRooms(rooms));
    }
}