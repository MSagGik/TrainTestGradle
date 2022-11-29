import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Train {
    private String name; // название поезда
    private String departurePoint; // место отправления
    private String placeOfArrival; // место прибытия
    private LocalDateTime departureDate; // время отправления
    private LocalDateTime arrivalDate; // время прибытия
    private double distance; // дистанция

    public Train() {
    }

    public Train(String name, String departurePoint, String placeOfArrival, String departureDate, String arrivalDate, double distance) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ошибка - название поезда было заданно пустым: [" + name + "]");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("Ошибка - было заданно отрицательная длина пути следования поезда: [" + distance + "]");
        }
        this.name = name;
        this.departurePoint = departurePoint;
        this.placeOfArrival = placeOfArrival;
        this.departureDate = LocalDateTime.parse(departureDate, DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"));
        this.arrivalDate = LocalDateTime.parse(arrivalDate, DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"));
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getPlaceOfArrival() {
        return placeOfArrival;
    }

    public void setPlaceOfArrival(String placeOfArrival) {
        this.placeOfArrival = placeOfArrival;
    }

    public String getDepartureDate() {
        return departureDate.format(DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"));
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDateOriginal() {
        return arrivalDate;
    }
    public LocalDateTime getDepartureDateOriginal() {
        return departureDate;
    }
    public String getArrivalDate() {
        return arrivalDate.format(DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"));
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Double.compare(train.distance, distance) == 0 && Objects.equals(name, train.name) && Objects.equals(departurePoint, train.departurePoint) && Objects.equals(placeOfArrival, train.placeOfArrival) && Objects.equals(departureDate, train.departureDate) && Objects.equals(arrivalDate, train.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, departurePoint, placeOfArrival, departureDate, arrivalDate, distance);
    }

    @Override
    public String toString() {
        return "Поезд " + name +
                ", отправляется из пункта " + departurePoint +
                " в " + departureDate.format(DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy")) +
                " года, прибывает в пункт " + placeOfArrival +
                " в " + arrivalDate.format(DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy")) +
                " года, расстояние пути " + distance + " километров";
    }

    // метод вычисляющий длительность пути
    public long travelTime () {
        return Duration.between(departureDate, arrivalDate).toHours(); // Duration.between - метод вычисляющий разность между двумя датами
    }

    // метод вычисляющий среднюю скорость в пути
    public double mediumSpeed() {
        return distance/ travelTime();
    }
}
