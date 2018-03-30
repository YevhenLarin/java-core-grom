package lesson11.homework;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Room room0 = new Room(101, 200, 1, new Date(), "Дн1", "Днепр");
        Room room1 = new Room(102, 250, 1, new Date(), "Дн2", "Днепр");
        Room room2 = new Room(103, 300, 2, new Date(), "Дн1", "Днепр");
        Room room3 = new Room(104, 400, 1, new Date(), "Льв", "Львов");
        Room room4 = new Room(105, 400, 3, new Date(), "Х1", "Харьков");
        Room room5 = new Room(106, 500, 4, new Date(), "Х1", "Харьков");
        Room room6 = new Room(107, 750, 5, new Date(), "К", "Киев");
        Room[] rooms = new Room[]{room0, room1, room2, room3, room4, room5, room6};

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        GoogleAPI googleAPI = new GoogleAPI(rooms);

        //поиск комнаты-------------------------------------------------------------------------------------------------

        //все параметры верны +
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(300, 1, "Днепр", "Дн1")));
        System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(400, 2, "Львов", "Льв")));
        System.out.println(Arrays.deepToString(googleAPI.findRooms(500, 4, "Харьков", "Х1")));
        System.out.println();

        //не тот отель +
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(500, 4, "Харьков", "Х2")));
        System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(500, 4, "Харьков", "X2")));
        System.out.println(Arrays.deepToString(googleAPI.findRooms(500, 4, "Харьков", "X2")));
        System.out.println();

        //не та цена +
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(50, 4, "Харьков", "Х1")));
        System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(50, 4, "Харьков", "Х1")));
        System.out.println(Arrays.deepToString(googleAPI.findRooms(50, 4, "Харьков", "Х1")));
        System.out.println();

        //не тот город +
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(300, 2, "Хацапетовка", "Дн1")));
        System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(300, 2, "Хацапетовка", "Дн1")));
        System.out.println(Arrays.deepToString(googleAPI.findRooms(300, 2, "Хацапетовка", "Дн1")));
        System.out.println();

        //все комнаты +
        System.out.println(Arrays.deepToString(bookingComAPI.getAll()));
        System.out.println(Arrays.deepToString(tripAdvisorAPI.getAll()));
        System.out.println(Arrays.deepToString(googleAPI.getAll()));
        System.out.println();

        //Controller----------------------------------------------------------------------------------------------------

        API[] apis = new API[]{bookingComAPI, tripAdvisorAPI, googleAPI};
        Controller controller = new Controller(apis);

        //TODO -
        //поиск комнаты всеми реализациям API
        //System.out.println(Arrays.deepToString(controller.requestRooms(300, 1, "Днепр", "Дн2")));

        //нахождение общих комнат у двух API +
        System.out.println(Arrays.deepToString(controller.check(bookingComAPI, tripAdvisorAPI)));

    }
}
