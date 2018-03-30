package lesson11.homework;

public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int high = persons + 1;
        int low = persons == 1 ? 1 : persons - 1;

        int count = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (room.getPersons() <= high && room.getPersons() >= low) {
                    if (room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel)
                        count++;
                }
            }
        }

        Room[] resultPersons = new Room[count];

        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (room.getPersons() <= high && room.getPersons() >= low) {
                    if (room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
                        resultPersons[index] = room;
                        index++;
                    }
                }
            }
        }
        return resultPersons;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
