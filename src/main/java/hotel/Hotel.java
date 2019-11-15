package hotel;

import room.BudgetRoom;
import room.LuxRoom;
import room.Room;
import room.UsualRoom;

import java.util.*;

public class Hotel {
    private String name;
    private Room room;
    private List<Room> listRooms = new ArrayList<>();

    public Hotel(String name){
        this.name = name;
    }
    public List showAllRooms (){
        listRooms.add(room = new BudgetRoom("Budget",2,4543));
        listRooms.add(room = new LuxRoom("Lux",3,6544));
        listRooms.add(room = new UsualRoom("Usual",4,4657));
        listRooms.add(room = new LuxRoom("Lux",2,6532));
        listRooms.add(room = new UsualRoom("Usual",3,2467));
        listRooms.add(room = new BudgetRoom("Budget",1,7533));
        listRooms.add(room = new UsualRoom("Usual",1,3254));
        listRooms.add(room=new BudgetRoom("Budget",3,2456));
        listRooms.add(room=new LuxRoom("Lux",1,6328));
        listRooms.add(room=new UsualRoom("Usual",3,2455));
        listRooms.add(room = new LuxRoom("Usual",2,2636));
        return listRooms;
    }

    public List showSortedRooms (){
        listRooms.sort(Comparator.comparing(Room::getNameType));
        return listRooms;
    }

    public void isCorrespond() {
        for (Room r : listRooms) {
            if (r.getGuestsCount() <= 3) {
                System.out.println("Room corresponds to your criteria");
                break;
            } else {
                System.out.println("There is no rooms that matches your criteria");
            }
        }
    }
    public void isCorrespondAll() {
        for (Room r : listRooms) {
            if (r.getNameType() == "Budget") {
                System.out.println("Room "+r.getRoomNumber() + " corresponds to your criteria");
            } else {
                System.out.println("Room "+r.getRoomNumber()+ " isn't matches your criteria");
            }
        }
    }
    public Set showUniqueRooms (){
        Set<Room> setRooms = new LinkedHashSet<>(listRooms);
        return setRooms;
    }

    public List<Room> getListRooms(){
        return listRooms;
    }

    public void setListRooms(List<Room> listRooms) {
        this.listRooms = listRooms;
    }
}
