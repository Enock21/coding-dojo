import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        System.out.println(Solution.canVisitAllRooms(rooms));
    }
}