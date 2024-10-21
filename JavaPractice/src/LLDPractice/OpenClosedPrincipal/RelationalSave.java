package LLDPractice.OpenClosedPrincipal;

public class RelationalSave implements DataSource{
    @Override
    public void save() {
        System.out.println("Save data to relational DB, ie. mysql");
        // logic
    }
}
