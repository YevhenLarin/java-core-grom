package lesson15.homework.API;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }


    public Room[] requestRooms(int price, int persons, String city, String hotel) {

        int count = 0;
        for (API api : apis) {
            if (api != null) {
                if (api.findRooms(price, persons, city, hotel).equals(api))
                    count++;
            }
        }

        Room[] result = new Room[count];

        int index = 0;
        for (API api : apis) {
            if (api != null) {
                for (Room room : api.findRooms(price, persons, city, hotel)) {
                    if (room != null) {
                        result[index] = room;
                        index++;
                    }
                }
            }
        }
        return result;
    }


    public Room[] check(API api1, API api2) {

        int count = 0;
        for (Room room1 : api1.getAll()) {
            if (room1 != null) {
                for (Room room2 : api2.getAll()) {
                    if (room2 != null) {
                        if (room1.equals(room2) && room1.hashCode() == room2.hashCode())
                            count++;
                    }
                }
            }
        }

        Room[] result = new Room[count];

        int index = 0;
        for (Room room1 : api1.getAll()) {
            if (room1 != null) {
                for (Room room2 : api2.getAll()) {
                    if (room2 != null) {
                        if (room1.equals(room2) && room1.hashCode() == room2.hashCode()) {
                            result[index] = room1;
                            index++;
                        }

                    }
                }
            }
        }
        return result;
    }
}
