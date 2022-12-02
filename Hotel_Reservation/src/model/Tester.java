package model;

public class Tester {
    public static void main(String[] args) {
        Customer customer = new Customer("first", "second", "j@domain.com");
        System.out.println(customer);

        // Customer customer2 = new Customer("first", "second", "email");
        // System.out.println(customer2);
        RoomType roomType = RoomType.SINGLE;

        Room room = new Room("210", 0.00, roomType);

        System.out.println(room);
    }
}
