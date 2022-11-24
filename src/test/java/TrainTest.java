import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    // тест геттеров и сеттеров сущности Train
    @Test
    public void examinationSetAndGetDateAndDistance() {
        Train trainOne = new Train();
        trainOne.setName("Moscow-Krasnodar");
        trainOne.setDistance(500);
        trainOne.setDepartureDate(LocalDateTime.of(2022, 11, 25, 9, 00));
        assertEquals("Moscow-Krasnodar", trainOne.getName());
        assertEquals(500, trainOne.getDistance());
        assertEquals(LocalDateTime.of(2022, Month.NOVEMBER, 25, 9, 00), trainOne.getDepartureDate());
    }

    // тест геттеров и конструктора сущности Train
    @Test
    public void examinationConstructorAndGet() {
        Train trainTwo = new Train("001 Moscow-Vologda","Moscow","Vologda",
                LocalDateTime.parse("2022-11-25 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                LocalDateTime.parse("2022-11-25 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                450);
        assertNotEquals("Moscow-Krasnodar", trainTwo.getName());
        assertNotEquals(500, trainTwo.getDistance());
        assertNotNull(trainTwo);
        assertEquals(LocalDateTime.parse("2022-11-25 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), trainTwo.getDepartureDate());
        assertNotEquals(LocalDateTime.parse("2022-11-25 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), trainTwo.getArrivalDate());
    }

    // тест объектов сущности
    @Test
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

    // тестирование методов вычисляющих длительность и среднюю скорость пути
    @Test
    public void examinationTravelTimeAndMediumSpeed() {
        Train trainSix = new Train();
        trainSix.setDepartureDate(LocalDateTime.of(2022, 11, 25, 12, 00));
        trainSix.setArrivalDate(LocalDateTime.parse("2022-11-25 15:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        trainSix.setDistance(210);
        assertEquals(3, trainSix.travelTime()); // тест метода вычисляющего время пути
        assertEquals(70, trainSix.mediumSpeed()); // тест метода вычисляющего среднюю скорость
    }

    // тест метода toString
    @Test
    public void examinationtoString() {
        Train trainSeven = new Train("Ярославль-Лукоморье","Ярославль","Лукоморье",
                LocalDateTime.of(2022, 11, 25, 16, 00),
                LocalDateTime.of(2022, 11, 25, 21, 00),
                1000);
        assertEquals("Поезд Ярославль-Лукоморье, отправляется из точки Ярославль в 2022-11-25T16:00, прибывает в точку Лукоморье в 2022-11-25T21:00, расстояние пути 1000.0",
                trainSeven.toString());
    }
}