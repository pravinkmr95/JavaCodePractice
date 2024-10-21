package GenericClasses;

//public class SimpleGeneric {
//    private Object data;
//
//    public Object getData(){
//        return this.data;
//    }
//
//    public void setData(Object data){
//        this.data = data;
//    }
//
//    public static void main(String[] args) {
//        SimpleGeneric obj = new SimpleGeneric();
//        obj.setData(10);
//        System.out.println(obj.getData());
//        System.out.println((int)obj.getData()+10);
//    }
//
//}

import javax.swing.*;

public class SimpleGeneric<T> {
    private T data;

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public static void main(String[] args) {
        SimpleGeneric<Integer> obj = new SimpleGeneric<>();
        obj.setData(10);
        System.out.println(obj.getData());
        System.out.println(obj.getData()+10);

        SimpleGeneric<String> stringObj = new SimpleGeneric<>();
        //stringObj.setData(10); error
        stringObj.setData("A");
        System.out.println(stringObj.getData() + "BCD");
    }

}
