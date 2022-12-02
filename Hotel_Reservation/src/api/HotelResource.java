package api;
/**
 * @author Marie Mueller
 * 
 * Hotel Resource should have little to no behaviourr contained inside
 * the class and should make use of the Service classes toimplement its
 * method
 */

import java.util.Collection;
import java.util.Date;

import model.Customer;
import model.IRoom;
import model.Reservation;

public class HotelResource {
    public Customer getCustomer(String email){}

    public void createACustomer(String email, String firstName, String lastName){}

    public IRoom getRoom(String roomNumber){}

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate){}

    public Collection<Reservation> getCustomerReservations(String customerEmail){}

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){}


}
