package DatabaseAccessLayer;

import PresentationLayer.model.TourModel;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseLayerPostGresTest {

    IDatabaseLayer db = new DatabaseLayerPostGres();

    @Test
    void testCreateConnection() throws SQLException, FileNotFoundException {
        assertEquals(db.createConnection(), true);
    }

    @Test
    void testAddTour() throws SQLException, FileNotFoundException {
        db.createConnection();
        db.addTour("thisTourDoesNotExist");
        assertNotEquals(0, db.getIdFromName("thisTourDoesNotExist"));
        assertEquals(0, db.getIdFromName("thisTourDoesNotExist2"));
        TourModel temp = new TourModel();
        temp.setTourName("thisTourDoesNotExist");
        db.removeTour(temp);
    }
}