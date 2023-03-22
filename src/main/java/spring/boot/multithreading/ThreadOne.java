package spring.boot.multithreading;
import org.json.JSONObject;
import spring.boot.services.TaskOne;
import java.text.ParseException;
public class ThreadOne implements Runnable{
    private TaskOne taskOne;
    private JSONObject jo;

    // Default Constructor
    public ThreadOne(){
        System.out.println("Thread One Default Constructor Called...");
    }
    // Parametrized Constructor
    public ThreadOne(JSONObject jo,TaskOne one)
    {
        this.jo = jo;
        this.taskOne = one;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start");
        try {
            String res = taskOne.one(jo);
            System.out.println(res);
        }
        catch (ParseException e) {
            System.out.println("Task 1 failed..");
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}
