import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTrain {
    public static void main(String[] args) {
        System.out.println("Список всех имеющихся поездов: " + addTrainsToList());
        System.out.println("Найдены поезда с местом прибытия Vologda: " + searchTrainLocation("Vologda"));
        System.out.println("Найдены поезда с местом прибытия Rybinsk и временем отправки 2022-11-25 17:00: " +
                searchTrainLocationAndTime("Rybinsk",LocalDateTime.of(2022, 11, 25, 17, 00)));

    }

    // метод поиска поезда по месту прибытия
    public static List<Train> searchTrainLocation(String location) {
        return addTrainsToList().stream().filter(p -> p.getPlaceOfArrival()==location).collect(Collectors.toList());
    }

    // метод поиска поезда по месту прибытия и времени  отправления
    public static List<Train> searchTrainLocationAndTime(String location, LocalDateTime departureDate) {
        return addTrainsToList().stream().filter(p -> p.getPlaceOfArrival()==location && p.getDepartureDate()==departureDate).collect(Collectors.toList());
    }

    // метод добавления списка поездов
    public static List<Train> addTrainsToList() {
        List<Train> trainList = new ArrayList<>();
        addTrainToList(trainList,"Yaroslavl","Vologda",
                LocalDateTime.of(2022, 11, 25, 10, 00),
                LocalDateTime.of(2022, 11, 25, 12, 00),
                250);
        addTrainToList(trainList,"Yaroslavl","Kostroma",
                LocalDateTime.of(2022, 11, 25, 14, 00),
                LocalDateTime.of(2022, 11, 25, 15, 00),
                90);
        addTrainToList(trainList,"Yaroslavl","Rybinsk",
                LocalDateTime.of(2022, 11, 25, 17, 00),
                LocalDateTime.of(2022, 11, 25, 19, 00),
                80);
        return trainList;
    }
    // метод добавления нового поезда Train в список поездов List<Train> trains
    public static List<Train> addTrainToList(List<Train> trains, String departurePoint, String placeOfArrival,
                                       LocalDateTime departureDate, LocalDateTime arrivalDate, double distance) {
        trains.add(new Train((departurePoint + " - " + placeOfArrival), departurePoint, placeOfArrival,
                departureDate, arrivalDate, distance));
        return trains;
    }
}
