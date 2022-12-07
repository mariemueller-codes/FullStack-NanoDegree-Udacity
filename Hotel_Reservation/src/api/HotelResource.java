package api;
/**
 * @author Marie Mueller
 * 
 * Hotel Resource should have little to no behaviourr contained inside
 * the class and should make use of the Service classes toimplement its
 * method
 */

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

public class HotelResource {
    private static final HotelResource SINGLETON = new HotelResource();

    private final CustomerService customerService = CustomerService.getSingleton();
    private final ReservationService reservationService = ReservationService.getSingleton();

    private HotelResource() {};

    public static HotelResource getSingleton(){return SINGLETON;}

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate){
        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, CheckOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail){
        final Customer customer = getCustomer(customerEmail);

        if (customer == null){return Collections.emptyList();}

        return reservationService.getCustReservation(getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return reservationService.findRooms(checkIn, checkOut);
    }

    public Collection<IRoom> findAlternativeRooms(final Date checkIn, final Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

    public Date addDefaultPlusDays(final Date date) {
        return reservationService.addDefaultDays(date);
    }


}
