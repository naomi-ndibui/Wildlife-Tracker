import org.junit.*;
import static org.junit.Assert.*;


public class EndangeredAnimalTest {

    EndangeredAnimal endangered1 = new EndangeredAnimal("Spotted Owl", "yes", "ill", "young");
    EndangeredAnimal endangered2 = new EndangeredAnimal("Black Rhino", "yes", "okay", "newborn");

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = endangered1;
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }
    
}
