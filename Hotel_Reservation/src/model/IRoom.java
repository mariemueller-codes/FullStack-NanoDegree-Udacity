package model;
/**
 * @ author Marie Mueller
 * Description: Model Classes for Data Objects
 */
public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree();
}
