package GenericClasses;

public class GenericMethod {
    public <T> void print(T obj){
        if (obj instanceof String){
            System.out.println("String passed " + obj);
        } else if (obj instanceof Integer) {
            System.out.println("Integer passed " + obj);
        } else {
            System.out.println("Unknown passed " + obj);
        }
    }

    public static void main(String[] args) {
        GenericMethod obj = new GenericMethod();
        obj.print("Test");
        obj.print(10);
        obj.print(10.1f);
    }
}
