package LLDPractice.OpenClosedPrincipal;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new NoSqlSave();
        dataSource.save();
    }
}
