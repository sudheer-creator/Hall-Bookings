package spring.boot.multithreading;

import org.json.JSONObject;
import spring.boot.exceptionhandling.InvalidBooking;
import spring.boot.services.TaskThree;
import spring.boot.services.TaskTwo;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadThree extends Thread{
    private TaskThree taskThree;
    private JSONObject jo;

    // Default Constructor
    public ThreadThree(){
        System.out.println("Thread Three Default Constructor Called...");
    }
    // Parametrized Constructor
    public ThreadThree(JSONObject jo, TaskThree taskThree)
    {
        this.jo = jo;
        this.taskThree= taskThree;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.");
        try {
            String res = taskThree.three(jo);
            System.out.println(res);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}
