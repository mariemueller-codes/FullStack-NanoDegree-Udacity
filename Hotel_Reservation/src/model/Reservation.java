package model;


import java.sql.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, java.util.Date checkInDate2, java.util.Date checkOutDate2){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate2;
        this.checkOutDate = checkOutDate2;
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
