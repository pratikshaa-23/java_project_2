import java.util.Scanner;

public class HotelManagementSystem {
    private static final int NUM_ROOMS = 10;
    private static boolean[] roomsAvailability = new boolean[NUM_ROOMS];

    public static void main(String[] args) {
        initializeRooms();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Hotel Management System");
            System.out.println("1. Book a room");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookRoom(scanner);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void initializeRooms() {
        for (int i = 0; i < NUM_ROOMS; i++) {
            roomsAvailability[i] = true; // All rooms are initially available
        }
    }

    private static void bookRoom(Scanner scanner) {
        System.out.println("Available rooms:");
        for (int i = 0; i < NUM_ROOMS; i++) {
            if (roomsAvailability[i]) {
                System.out.println("Room " + (i + 1));
            }
        }

        System.out.print("Enter the room number you want to book: ");
        int roomNumber = scanner.nextInt();

        if (roomNumber < 1 || roomNumber > NUM_ROOMS) {
            System.out.println("Invalid room number!");
            return;
        }

        if (roomsAvailability[roomNumber - 1]) {
            roomsAvailability[roomNumber - 1] = false;
            System.out.println("Room " + roomNumber + " booked successfully!");
        } else {
            System.out.println("Room " + roomNumber + " is already booked!");
        }
    }
}
