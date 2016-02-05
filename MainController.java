import java.util.ArrayList;

/**
    Briley Marchetti
**/

public class MainController{
    public static void main(String[] args){

        Thread t1 = new Thread(new RunThread());
        Thread t2 = new Thread(new RunThread());
    }
}
