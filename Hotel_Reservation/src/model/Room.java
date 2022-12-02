package model;

import java.util.Objects;

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

    public boolean isFree(){return this.price != null && this.price.equals(0.00);}

    @Override
    public boolean equals(Object obj){
        if(this == obj){return true;}
        
        if((obj == null) || (obj.getClass() != this.getClass())){return false;}

        Room room = (Room) obj;

        return Objects.equals(this.roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode(){return Objects.hash(roomNumber);}

    @Override
    public String toString(){
        return "Room No.: " + this.roomNumber
                + " Price: $" + this.price
                + " Enumeration: " + this.enumeration;
    }
}
