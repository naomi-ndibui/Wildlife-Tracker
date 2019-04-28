import org.sql2o.*;

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
    public void save() {
        if (name.equals("")) {
            throw new IllegalArgumentException("Please enter a name.");
        }
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, endangered) VALUES (:name, :endangered)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("endangered", this.endangered)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }

}
