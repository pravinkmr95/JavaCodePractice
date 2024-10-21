package LLDPractice.InterfacesSegmented;

public class Chef implements RestaurantEmployee{
    @Override
    public void cleanKitchen() {
        //System.out.println("");
        // ignore
    }

    @Override
    public void decideMenu() {
        System.out.println("Deciding menu");
    }

    @Override
    public void cookFood() {
        System.out.println("Cooking food");
    }

    @Override
    public void openRestaurant() {
        //ignore
    }
}
