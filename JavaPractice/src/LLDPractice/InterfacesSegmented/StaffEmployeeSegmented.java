package LLDPractice.InterfacesSegmented;

public class StaffEmployeeSegmented implements ServiceStaff{
    @Override
    public void serveCustomers() {
        System.out.println("Serving customers");
    }

    @Override
    public void cleanKitchen() {
        System.out.println("cleaning kitchen");
    }
}
