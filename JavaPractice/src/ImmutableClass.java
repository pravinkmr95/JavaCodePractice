import java.util.ArrayList;
import java.util.Date;
import java.util.List;

final class ImmutableClass {
    private final String name;
    private final List<Object> petList;
    private final Date date;

    ImmutableClass(String name, List<Object> petList){
        this.name = name;
        this.petList = petList;
        this.date = new Date();
    }

    public Date getDate(){
        return new Date(date.getTime());
        // return this.date;
    }

    public String getName(){
        return this.name;
    }

    public List<Object> getPetList(){
        return new ArrayList<>(this.petList);
        //return this.petList;
    }

    public static void main(String[] args) throws InterruptedException {
        String name = "x";
        List<Object> petList = new ArrayList<>();
        petList.add("a");
        petList.add("b");
        petList.add("C");

        ImmutableClass obj = new ImmutableClass(name, petList);
        String nameX = obj.getName();
        nameX += "XYZ";
        System.out.println(nameX + " -> " + obj.getName());

        List<Object> petListX = obj.getPetList();
        petListX.add("DF");
        System.out.println(petListX + " -> " + obj.getPetList());

        Date d1 = obj.getDate();
        Thread.sleep(2500);
        d1 = new Date();
        System.out.println(obj.getDate()  + " -> " + d1 + " " + (d1 == obj.getDate()));
    }
}
