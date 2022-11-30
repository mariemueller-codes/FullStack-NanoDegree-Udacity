package service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import model.Customer;
import model.IRoom;
import model.Reservation;

public class ReservationService {

    public static ReservationService SINGLETON = new ReservationService();

    private Map<String, IRoom> rooms = new HashMap<>();


    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId){
        return rooms.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        Collection<Reservation> customerReservationss = getCustomerReservation(customer);
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){}

    public Collection<Reservation> getReservation(Customer customer){}

    public void printAllReservation(){
        Collection<Reservation> reservations = getAllReservations();
    }




}
