package model;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, java.util.Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public IRoom getRoom(){return this.room;}

    public Date getCheckInDate(){return this.checkInDate;}

    public Date getCheckOutDate(){return this.checkOutDate;}

    @Override
    public String toString(){
        return "Customer: " + this.customer.toString()
            + " \nRoom: " + this.room.toString()
            + " \nCheck-in Date: " + this.checkInDate
            + " \nCheck-out Date: " + this.checkOutDate;
    }


    
}
