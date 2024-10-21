package LLDPractice.DependencyInversion;


public class Computer {
//    WiredKeyBoard wiredKeyBoard; // type should be of parent
//    WiredMouse wiredMouse;
//    public Computer(){
//        this.wiredKeyBoard = new WiredKeyBoard();
//        this.wiredMouse = new WiredMouse();
//    }
    private KeyBoardInterface keyBoard;
    private MouseInterface mouse;
    //Mouse mouse = new Mouse();

    public Computer(MouseInterface mouse, KeyBoardInterface keyBoard){
        this.mouse = mouse;
        //this.mouse = new Mouse("wired"); fixed breaking I
        this.keyBoard = keyBoard;
        //this.keyBoard = new KeyBoard('wired'); //fixed-> breaking I
    }

    public void setMouse(MouseInterface newMouse){
        this.mouse = newMouse;
    }
}
