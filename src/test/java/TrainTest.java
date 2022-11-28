import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Набор тестов для сущности Train")
class TrainTest {
    @BeforeEach
    @DisplayName("Метод запускаемый перед каждым тестом")
    public void setUp() {
        Train trainExample = new Train("Ярославль-Данилов","Ярославль","Данилов",
                LocalDateTime.of(2022, 11, 25, 00, 00),
                LocalDateTime.of(2022, 11, 25, 01, 00),
                90);
        assertTrue(trainExample.equals(trainExample));
    }

    @Test
    @DisplayName("Тест геттеров и сеттеров сущности Train")
    public void examinationSetAndGetDateAndDistance() {
        Train trainOne = new Train();
        trainOne.setName("Moscow-Krasnodar");
        trainOne.setDistance(500);
        trainOne.setDepartureDate(LocalDateTime.of(2022, 11, 25, 9, 00));
        assertEquals("Moscow-Krasnodar", trainOne.getName());
        assertEquals(500, trainOne.getDistance());
        assertEquals(LocalDateTime.of(2022, Month.NOVEMBER, 25, 9, 00), trainOne.getDepartureDateOriginal());
    }

    @Test
    @DisplayName("Тест геттеров и конструктора сущности Train")
    public void examinationConstructorAndGet() {
        Train trainTwo = new Train("001 Moscow-Vologda","Moscow","Vologda",
                LocalDateTime.parse("2022-11-25 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                LocalDateTime.parse("2022-11-25 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                450);
        assertNotEquals("Moscow-Krasnodar", trainTwo.getName());
        assertNotEquals(500, trainTwo.getDistance());
        assertNotNull(trainTwo);
        assertEquals(LocalDateTime.parse("2022-11-25 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), trainTwo.getDepartureDateOriginal());
        assertNotEquals(LocalDateTime.parse("2022-11-25 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), trainTwo.getArrivalDateOriginal());
    }

    @Test
    @DisplayName("Тест объектов сущности")
    public void examinationEntity() {
        Train trainThree = new Train("007 Yaroslavl-Kostroma","Yaroslavl","Kostroma",
                LocalDateTime.of(2022, 11, 25, 11, 00),
                LocalDateTime.of(2022, 11, 25, 14, 00),
                90);
        Train trainFour = new Train("007 Yaroslavl-Kostroma","Yaroslavl","Kostroma",
                LocalDateTime.of(2022, 11, 25, 11, 00),
                LocalDateTime.of(2022, 11, 25, 14, 00),
                90);
        Train trainFive = new Train("005 Yaroslavl-Rybinsk","Yaroslavl","Rybinsk",
                LocalDateTime.of(2022, 11, 25, 11, 00),
                LocalDateTime.of(2022, 11, 25, 14, 00),
                80);
        assertTrue(trainThree.equals(trainThree));
        assertTrue(trainThree.equals(trainFour));
        assertFalse(trainThree.equals(trainFive));
        assertFalse(trainFour.equals(trainFive));
    }

    @ParameterizedTest
    @CsvSource({
            " , Ярославль, Лукоморье, 16:00 25.11.2022, 16:00 25.11.2022, 1000",
            "Ярославль - Лукоморье , Ярославль, Лукоморье, 16:00 25.11.2022, 16:00 25.11.2022, -1000"
    })
    @DisplayName("Параметризованный тест исключений")
    public void whenDataIsIncorrect_ExceptionIsThrown(String name, String departurePoint, String placeOfArrival,
                                                      String departureDateString, String arrivalDateString, double distance) {
        ///
        LocalDateTime departureDate = LocalDateTime.parse(departureDateString,DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"));
        LocalDateTime arrivalDate = LocalDateTime.parse(arrivalDateString,DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"));
        ///
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Train train = new Train(name,departurePoint, placeOfArrival, departureDate, arrivalDate, distance);
        });
        String expectedPartOfMessage = "Ошибка";
        System.out.println(exception.getMessage());
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedPartOfMessage));
    }

    @Test
    @DisplayName("Тестирование методов вычисляющих длительность и среднюю скорость пути")
    public void examinationTravelTimeAndMediumSpeed() {
        Train trainSix = new Train();
        trainSix.setDepartureDate(LocalDateTime.of(2022, 11, 25, 12, 00));
        trainSix.setArrivalDate(LocalDateTime.parse("2022-11-25 15:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        trainSix.setDistance(210);
        assertEquals(3, trainSix.travelTime()); // тест метода вычисляющего время пути
        assertEquals(70, trainSix.mediumSpeed()); // тест метода вычисляющего среднюю скорость
    }

    @Test
    @DisplayName("Тест метода toString")
    public void examinationtoString() {
        Train trainSeven = new Train("Ярославль - Лукоморье","Ярославль","Лукоморье",
                LocalDateTime.of(2022, 11, 25, 16, 00),
                LocalDateTime.of(2022, 11, 25, 21, 00),
                1000);
        assertEquals("Поезд Ярославль - Лукоморье, отправляется из пункта Ярославль в 16:00 25.11.2022 года, прибывает в пункт Лукоморье в 21:00 25.11.2022 года, расстояние пути 1000.0 километров",
                trainSeven.toString());
    }
}