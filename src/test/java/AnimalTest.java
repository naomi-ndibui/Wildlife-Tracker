import org.junit.*;

import static org.junit.Assert.*;

public class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = animal1;
        assertEquals(true, testAnimal instanceof Animal);
    }
    @Test
    public void getName_animalInstantiatesWithName_koala() {
        Animal testAnimal = animal1;
        assertEquals("koala", testAnimal.getName());
    }
    @Test
    public void getEndangered_animalInstantiatesWithEndangered_No() {
        Animal testAnimal = animal1;
        assertEquals("No", testAnimal.getEndangered());
    }
    @Test
    public void equals_returnsTrueIfNameAreSame_true() {
        Animal testAnimal = animal1;
        Animal anotherAnimal = animal1;
        assertTrue(testAnimal.equals(anotherAnimal));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal testAnimal = animal1;
        testAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(testAnimal));
    }
    @Test
    public void save_assignsIdToAnimal() {
        Animal testAnimal = animal1;
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(savedAnimal.getId(), testAnimal.getId());
    }

}
