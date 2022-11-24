import java.time.Duration;
import java.time.LocalDateTime;
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

    public Train(String name, String departurePoint, String placeOfArrival, LocalDateTime departureDate, LocalDateTime arrivalDate, double distance) {
        this.name = name;
        this.departurePoint = departurePoint;
        this.placeOfArrival = placeOfArrival;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
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

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
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
                ", отправляется из точки " + departurePoint +
                " в " + departureDate +
                ", прибывает в точку " + placeOfArrival +
                " в " + arrivalDate +
                ", расстояние пути " + distance;
    }

    // метод вычисляющий длительность пути
    public long travelTime () {
        return Duration.between(getDepartureDate(), getArrivalDate()).toHours(); // Duration.between - метод вычисляющий разность между двумя датами
    }

    // метод вычисляющий среднюю скорость в пути
    public double mediumSpeed() {
        return distance/ travelTime();
    }
}