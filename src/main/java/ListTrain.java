import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTrain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + "Список всех имеющихся поездов: " + ANSI_RESET + addTrainsToList());
        System.out.println(ANSI_PURPLE + "Найдены поезда с местом прибытия 'Вологда': " + ANSI_RESET + searchTrainLocation("Вологда"));
        System.out.println(ANSI_CYAN + "Найдены поезда с местом прибытия 'Рыбинск' и временем отправки в 17:00 25.11.2022 года: " + ANSI_RESET +
                searchTrainLocationAndTime("Рыбинск","17:00 25.11.2022"));

    }

    // метод поиска поезда по месту прибытия
    public static List<Train> searchTrainLocation(String location) {
        return addTrainsToList().stream().filter(p -> p.getPlaceOfArrival()==location).collect(Collectors.toList());
    }

    // метод поиска поезда по месту прибытия и времени  отправления
    public static List<Train> searchTrainLocationAndTime(String location, String departureDate) {
        return addTrainsToList().stream().filter(p -> p.getPlaceOfArrival().equals(location) && p.getDepartureDate().equals(departureDate)).collect(Collectors.toList());
    }

    // метод добавления списка поездов
    public static List<Train> addTrainsToList() {
        List<Train> trainList = new ArrayList<>();
        addTrainToList(trainList,"Ярославль","Вологда",
                "10:00 25.11.2022",
                "12:00 25.11.2022",
                //LocalDateTime.of(2022, 11, 25, 10, 00),
                //LocalDateTime.of(2022, 11, 25, 12, 00),
                250);
        addTrainToList(trainList,"Ярославль","Кострома",
                "14:00 25.11.2022",
                "15:00 25.11.2022",
                //LocalDateTime.of(2022, 11, 25, 14, 00),
                //LocalDateTime.of(2022, 11, 25, 15, 00),
                90);
        addTrainToList(trainList,"Ярославль","Рыбинск",
                "17:00 25.11.2022",
                "19:00 25.11.2022",
                //LocalDateTime.of(2022, 11, 25, 17, 00),
                //LocalDateTime.of(2022, 11, 25, 19, 00),
                80);
        addTrainToList(trainList,"Ярославль","Лукоморье",
                "16:00 25.11.2022",
                "21:00 25.11.2022",
                //LocalDateTime.of(2022, 11, 25, 16, 00),
                //LocalDateTime.of(2022, 11, 25, 21, 00),
                1000);
        return trainList;
    }
    // метод добавления нового поезда Train в список поездов List<Train> trains
    public static List<Train> addTrainToList(List<Train> trains, String departurePoint, String placeOfArrival,
                                       String departureDate, String arrivalDate, double distance) {
        trains.add(new Train((departurePoint + " - " + placeOfArrival), departurePoint, placeOfArrival,
                departureDate, arrivalDate, distance));
        return trains;
    }
}
