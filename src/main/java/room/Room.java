package room;

public abstract class Room {
    private String nameType;
    private int guestsCount;
    private int roomNumber;

    public Room(String nameType,int guestsCount,int roomNumber){
        this.nameType=nameType;
        this.guestsCount=guestsCount;
        this.roomNumber=roomNumber;
    }
    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public int getGuestsCount() {
        return guestsCount;
    }

    public void setGuestsCount(int guestsCount) {
        this.guestsCount = guestsCount;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    @Override
    public String toString(){
        return  "Room type : " + this.getNameType() +" and "+
                "Amount of guest : " + this.getGuestsCount() +"\n";
    }
}
