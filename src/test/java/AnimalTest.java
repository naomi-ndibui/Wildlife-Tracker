import org.junit.*;

import static org.junit.Assert.*;

public class AnimalTest {
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

}
