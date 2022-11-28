import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Набор тестов для списка поездов")
class ListTrainTest {

    @Test
    @DisplayName("Тест метода поиска поезда с конкретным пунктом назначения")
    void searchTrainLocation() {
        List<Train> oneSearchList = ListTrain.searchTrainLocation("Вологда");
        List<Train> twoSearchList = ListTrain.searchTrainLocation("Кострома");
        List<Train> threeSearchList = ListTrain.searchTrainLocation("Вологда");
        assertEquals(oneSearchList, threeSearchList);
        assertNotEquals(oneSearchList, twoSearchList);
    }

    @ParameterizedTest
    @ValueSource( strings = {"Москва", "Вологда", "Кострома"})
    @DisplayName("Параметризованный тест метода поиска поезда с конкретным пунктом назначения")
    void searchTrainLocationParameter(String city) {
        List<Train> oneSearchList = ListTrain.searchTrainLocation(city);
        List<Train> threeSearchList = ListTrain.searchTrainLocation(city);
        assertEquals(oneSearchList, threeSearchList);
    }

    @Test
    void searchTrainLocationAndTime() {
    }

    @Test
    @DisplayName("Тест метода добавления поездов в список")
    void addTrainsToList() {
        List<Train> oneList = ListTrain.addTrainsToList();
        List<Train> twoList = ListTrain.addTrainsToList();
        assertEquals(oneList, twoList);
    }
}