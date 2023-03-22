package spring.boot.multithreading;

import org.json.JSONObject;
import spring.boot.exceptionhandling.InvalidBooking;
import spring.boot.services.TaskFour;
import spring.boot.services.TaskTwo;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadFour extends Thread{
    private TaskFour taskFour;
    private JSONObject jo;

    // Default Constructor
    public ThreadFour(){
        System.out.println("Thread Four Default Constructor Called...");
    }
    public ThreadFour(JSONObject jo, TaskFour taskFour)
    {
        this.jo = jo;
        this.taskFour = taskFour;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.");
        try {
            String res = taskFour.four(jo);
            System.out.println(res);
        }
        catch (InvalidBooking e) {
            System.out.println("Invalid booking");
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }

}
