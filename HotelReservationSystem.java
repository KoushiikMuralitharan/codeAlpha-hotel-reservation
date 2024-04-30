import java.util.*;

class Hotel {
    private Map<Integer, Boolean> rooms;
    private Map<Integer, PersonalDetails> guests;

    public Hotel(int numberOfRooms) {
        rooms = new HashMap<>();
        guests = new HashMap<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.put(i, false); // false indicates room is available
        }
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Map.Entry<Integer, Boolean> entry : rooms.entrySet()) {
            if (!entry.getValue()) {
                System.out.println("Room " + entry.getKey());
            }
        }
    }

    public void bookRoom(int roomNumber, PersonalDetails details) {
        if (rooms.containsKey(roomNumber) && !rooms.get(roomNumber)) {
            rooms.put(roomNumber, true); // true indicates room is booked
            guests.put(roomNumber, details); // Store guest details for the booked room
            System.out.println("Room " + roomNumber + " booked successfully!");
            System.out.println("Personal Details for Room " + roomNumber + ":");
            System.out.println(details);
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    public void cancelBooking(int roomNumber) {
        if (rooms.containsKey(roomNumber) && rooms.get(roomNumber)) {
            rooms.put(roomNumber, false); // false indicates room is available again
            guests.remove(roomNumber); // Remove guest details for the cancelled booking
            System.out.println("Booking for Room " + roomNumber + " cancelled successfully!");
        } else {
            System.out.println("No booking found for Room " + roomNumber);
        }
    }
}

class PersonalDetails {
    private String name;
    private int age;
    private String phoneNumber;
    private String address;

    public PersonalDetails(String name, int age, String phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Phone Number: " + phoneNumber + ", Address: " + address;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hotel Reservation System");
        System.out.print("Enter the number of rooms in the hotel: ");
        int numberOfRooms = scanner.nextInt();
        Hotel hotel = new Hotel(numberOfRooms);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomToBook = scanner.nextInt();
                    System.out.print("Enter guest name: ");
                    String name = scanner.next();
                    System.out.print("Enter guest age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter guest phone number: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Enter guest address: ");
                    String address = scanner.next();
                    PersonalDetails details = new PersonalDetails(name, age, phoneNumber, address);
                    hotel.bookRoom(roomToBook, details);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel booking: ");
                    int roomToCancel = scanner.nextInt();
                    hotel.cancelBooking(roomToCancel);
                    break;
                case 4:
                    System.out.println("Thank you for using Hotel Reservation System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
 
