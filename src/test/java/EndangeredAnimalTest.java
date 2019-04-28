import org.junit.*;
import static org.junit.Assert.*;


public class EndangeredAnimalTest {

    EndangeredAnimal endangered1 = new EndangeredAnimal("Spotted koala", "yes", "ill", "young");
    EndangeredAnimal endangered2 = new EndangeredAnimal("Spotted cat", "yes", "okay", "newborn");

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = endangered1;
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }

}
