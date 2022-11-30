package model;
/**
 * @ author Marie Mueller
 * Description: Model Classes for Data Objects
 */
public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration){
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    public String getRoomNumber(){return this.roomNumber;}

    public Double getRoomPrice(){return this.price;}

    public RoomType getRoomType(){return this.enumeration;}

    public boolean isFree(){return this.price != null && this.price.equals(0.0);}

    @Override
    public String toString(){
        return "Room No.: " + this.roomNumber
                + " Price: $" + this.price
                + " Enumeration: " + this.enumeration;
    }
}
