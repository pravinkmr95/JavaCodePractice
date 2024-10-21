package Singleton;

public class BillPugh {
    private BillPugh(){
    }

    private static class Inner{
        private static final BillPugh instance = new BillPugh();
    }

    public static BillPugh getInstance(){
        return Inner.instance;
    }
}
