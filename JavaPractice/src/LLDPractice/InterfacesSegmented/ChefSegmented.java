package LLDPractice.InterfacesSegmented;

public class ChefSegmented implements CookingStaff{
    @Override
    public void cookFood() {
        System.out.println("Cook");
    }

    @Override
    public void decideMenu() {
        System.out.println("decide menu");
    }
}
