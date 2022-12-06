package service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Calendar;
import java.util.Collection;

import model.Customer;
import model.IRoom;
import model.Reservation;

public class ReservationService {

    public static ReservationService SINGLETON = new ReservationService();
    private static final int DEFAULT_DAYS= 7;

    private Map<String, IRoom> rooms = new HashMap<>();
    private Map<String, Collection<Reservation>> reservations = new HashMap<>();

    private ReservationService(){}

    public static ReservationService getSingleton(){return SINGLETON;}


    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId){
        return rooms.get(roomId);
    }

    public Collection<IRoom> getAllRooms(){return rooms.values();}

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        Collection<Reservation> customerReservations = getCustReservation(customer);

        if(customerReservations == null){
            customerReservations = new LinkedList<>();
        }

        customerReservations.add(reservation);
        reservations.put(customer.getEmail(), customerReservations);

        return reservation;
    }

    public Collection<Reservation> getCustReservation(Customer customer){return reservations.get(customer.getEmail());}

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        return findAvailRooms(checkInDate, checkOutDate);
    }

    private Collection<IRoom> findAvailRooms(Date checkInDate, Date checkOutDate){
        final Collection<Reservation> allReserved = getAllReservations();
        final Collection<IRoom> occupiedRooms = new LinkedList<>();

        for (Reservation reservation : allReserved) {
            if (reserveOverlaps(reservation, checkInDate, checkOutDate)){
                occupiedRooms.add(reservation.getRoom());
            }     
        }
        return rooms.values().stream().filter(room -> occupiedRooms.stream()
                .noneMatch(occupiedRoom -> occupiedRoom.equals(room)))
                .collect(Collectors.toList());
    }

    public Date addDefaultDays(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, DEFAULT_DAYS);

        return calendar.getTime();
    }

    private boolean reserveOverlaps(Reservation reservation, Date checkInDate, Date checkOutDate){
        return checkInDate.before(reservation.getCheckOutDate()) && checkOutDate.after(reservation.getCheckInDate());
    }

    public Collection<Reservation> getAllReservations(){
        final Collection<Reservation> allReservations = new LinkedList<>();

        for(Collection<Reservation> reservations: reservations.values()){
            allReservations.addAll(reservations);
        }
        return allReservations;
    }


    public void printAllReservation(){
        Collection<Reservation> reservations = getAllReservations();

        if (reservations.isEmpty()){
            System.out.println("No reservation");
        }
        else{
            for(Reservation reservation:reservations){
                System.out.println(reservation + "\n");
            }
        }
    }

}
