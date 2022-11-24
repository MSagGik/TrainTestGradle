import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListTrainTest {

    @Test
    void searchTrainLocation() {
        List<Train> oneSearchList = ListTrain.searchTrainLocation("Vologda");
        List<Train> twoSearchList = ListTrain.searchTrainLocation("Kostroma");
        List<Train> threeSearchList = ListTrain.searchTrainLocation("Vologda");
        assertEquals(oneSearchList, threeSearchList);
        assertNotEquals(oneSearchList, twoSearchList);
    }

    @Test
    void searchTrainLocationAndTime() {
    }

    @Test
    void addTrainsToList() {
        List<Train> oneList = ListTrain.addTrainsToList();
        List<Train> twoList = ListTrain.addTrainsToList();
        assertEquals(oneList, twoList);
    }
}