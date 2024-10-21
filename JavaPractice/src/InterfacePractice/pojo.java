package InterfacePractice;

public class pojo {
    public int x;
    private static final int y = 10;

    public int getX(){
        return this.x + pojo.y;
    }

    public static int getY(){
        return pojo.y;
    }

    public static void main(String[] args) {
        pojo obj = new pojo();
        obj.getX();
        System.out.println(pojo.getY());
    }
}
