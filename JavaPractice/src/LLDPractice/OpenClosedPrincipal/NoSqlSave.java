package LLDPractice.OpenClosedPrincipal;

public class NoSqlSave implements DataSource{
    @Override
    public void save() {
        System.out.println("Saving data to nosql: ex: mongoDb");
        // logic
    }
}
