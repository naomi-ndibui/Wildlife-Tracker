import org.junit.*;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

public class SightingTest {

    Sighting sighting1 = new Sighting("Henry", "Zone B", 1);
    Sighting sighting2 = new Sighting("Henrietta", "Zone A", 2);

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true() {
        Sighting testSighting = sighting1;
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void getRangerName_personInstantiatesWithRangerName_Henry() {
        Sighting testSighting = sighting1;
        assertEquals("Henry", testSighting.getRangerName());
    }

    @Test
    public void getLocation_personInstantiatesWithLocation_ZoneB() {
        Sighting testSighting = sighting1;
        assertEquals("Zone B", testSighting.getLocation());
    }

    @Test
    public void getAnimalId_personInstantiatesWithAnimalId_1() {
        Sighting testSighting = sighting1;
        assertEquals(1, testSighting.getAnimalId());
    }

    @Test
    public void equals_returnsTrueIfNameAndLocationAreSame_true() {
        Sighting testSighting = sighting1;
        Sighting anotherSighting = sighting1;
        assertTrue(testSighting.equals(anotherSighting));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Sighting() {
        Sighting testSighting = sighting1;
        testSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(testSighting));
    }

    @Test
    public void save_assignsIdToSighting() {
        Sighting testSighting = sighting1;
        testSighting.save();
        Sighting savedSighting = Sighting.all().get(0);
        assertEquals(savedSighting.getId(), testSighting.getId());
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sighting firstSighting = sighting1;
        firstSighting.save();
        Sighting secondSighting = sighting2;
        secondSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
    }

    @Test
    public void find_returnsSightingWithSameId_secondSighting() {
        Sighting firstSighting = sighting1;
        firstSighting.save();
        Sighting secondSighting = sighting2;
        secondSighting.save();
        assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
    }

    @Test
    public void save_recordsTimeOfCreationInDatabase() {
        Sighting testSighting = sighting1;
        testSighting.save();
        Timestamp savedSightingTime = Sighting.find(testSighting.getId()).getTimestamp();
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(rightNow.getDay(), savedSightingTime.getDay());
    }

}
