public class Animal {
    public String name;
    public String endangered;
    public int id;

    public Animal(String name, String endangered){
        this.name = name;
        this.endangered = endangered;
    }
    public String getName() {
        return name;
    }

    public String getEndangered() {
        return endangered;
    }

    public int getId() {
        return id;
    }
}
