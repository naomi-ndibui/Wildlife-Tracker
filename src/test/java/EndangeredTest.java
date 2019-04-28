import org.junit.*;
import static org.junit.Assert.*;


public class EndangeredTest {

    Endangered endangered1 = new Endangered("Spotted koala", "yes", "ill", "young");
    Endangered endangered2 = new Endangered("Spotted cat", "yes", "okay", "newborn");

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        Endangered testEndangered = endangered1;
        assertEquals(true, testEndangered instanceof Endangered);
    }
    @Test
    public void getName_animalInstantiatesWithName_koala() {
        Endangered testEndangered = endangered1;
        assertEquals("Spotted koala", testEndangered.getName());
    }
    @Test
    public void getEndangered_animalInstantiatesWithEndangered_no() {
        Endangered testEndangered = endangered1;
        assertEquals("yes", testEndangered.getEndangered());
    }
    @Test
    public void getEndangered_personInstantiatesWithAge_young() {
        Endangered testEndangered = endangered1;
        assertEquals("young", testEndangered.getAge());
    }

    @Test
    public void getEndangered_personInstantiatesWithHealth_ill() {
        Endangered testEndangered = endangered1;
        assertEquals("ill", testEndangered.getHealth());
    }

    @Test
    public void equals_returnsTrueIfNameAreSame_true() {
        Endangered testEndangered = endangered1;
        Endangered anotherEndangered = endangered1;
        assertTrue(testEndangered.equals(anotherEndangered));
    }

    @Test
    public void save_insertsObjectIntoDatabase_EndangeredAnimal() {
        Endangered testEndangered = endangered1;
        testEndangered.save();
        assertEquals(true, Animal.all().get(0).equals(testEndangered));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal() {
        Endangered testEndangered = endangered1;
        testEndangered.save();
        Animal savedEndangeredAnimal = Animal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(), testEndangered.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        Endangered firstEndangered = endangered1;
        firstEndangered.save();
        Endangered secondEndangered = endangered2;
        secondEndangered.save();
        assertEquals(true, Animal.all().get(0).equals(firstEndangered));
        assertEquals(true, Animal.all().get(1).equals(secondEndangered));
    }

    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
        Endangered firstEndangered = endangered1;
        firstEndangered.save();
        Endangered secondEndangered = endangered2;
        secondEndangered.save();
        assertEquals(Animal.find(secondEndangered.getId()), secondEndangered);
    }

    @Test
    public void setEndangered_Animal_true() {
        Endangered myEndangered = new Endangered("Spotted koala", "no", "healthy", "young");
        myEndangered.save();
        myEndangered.setEndangered("yes", "ill", "newborn");
        assertEquals("yes", Endangered.find(myEndangered.getId()).getEndangered());
        assertEquals("ill", Endangered.find(myEndangered.getId()).getHealth());
        assertEquals("newborn", Endangered.find(myEndangered.getId()).getAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setEndangered_throwsExceptionIfHealthIsNotAChoice(){
        Endangered myEndangered = new Endangered("Spotted koala", "no", "healthy", "young");
        myEndangered.save();
        myEndangered.setEndangered("yes", "blech", "newborn");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setEndangered_throwsExceptionIfAgeIsNotAChoice(){
        Endangered myEndangered = new Endangered("Spotted koala", "no", "healthy", "young");
        myEndangered.save();
        myEndangered.setEndangered("yes", "ill", "blech");
    }
}
