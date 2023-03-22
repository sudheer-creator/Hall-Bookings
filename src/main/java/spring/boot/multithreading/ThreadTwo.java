package spring.boot.multithreading;
import org.json.JSONObject;
import spring.boot.exceptionhandling.InvalidBooking;
import spring.boot.services.TaskTwo;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTwo implements Runnable{
    private TaskTwo taskTwo;
    private ThreadPoolExecutor executor;
    private JSONObject jo;

    // Default Constructor
    public ThreadTwo(){
        System.out.println("Thread Two Default Constructor Called...");
    }
    // Parametrized Constructor
    public ThreadTwo(JSONObject jo, TaskTwo taskTwo)
    {
        this.jo = jo;
        this.taskTwo = taskTwo;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start");
        try {
            String res = taskTwo.two(jo);
            System.out.println(res);
        }
        catch (InvalidBooking e) {
            System.out.println("Invalid Booking");
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}
