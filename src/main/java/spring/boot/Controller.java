package spring.boot;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import spring.boot.exceptionhandling.InvalidBooking;
import spring.boot.multithreading.ThreadFour;
import spring.boot.multithreading.ThreadOne;
import spring.boot.multithreading.ThreadThree;
import spring.boot.multithreading.ThreadTwo;
import spring.boot.services.TaskFour;
import spring.boot.services.TaskOne;
import spring.boot.services.TaskThree;
import spring.boot.services.TaskTwo;

import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class Controller {
    @GetMapping("/spring")
    public String spring() {
        return "Spring boot";
    }
    @Autowired
    TaskOne taskOne;
    @Autowired
    TaskTwo taskTwo;
    @Autowired
    TaskThree taskThree;
    @Autowired
    TaskFour taskFour;

    // Server
    @Autowired()
    @Qualifier("server")
    ExecutorService executorService;


    @PostMapping("/task1")
    public void task1(@RequestBody String s){
        JSONObject jo = new JSONObject(s);
        executorService.execute(new ThreadOne(jo,taskOne));
    }
    @PostMapping("/task2")
    public String task2(@RequestBody String s){
        JSONObject jo = new JSONObject(s);
        executorService.execute(new ThreadTwo(jo,taskTwo));
        return "task2";
    }
    @PostMapping("/task3")
    public String task3(@RequestBody String s)  {
        JSONObject jo = new JSONObject(s);
        executorService.execute(new ThreadThree(jo,taskThree));
        return "task3";
    }
    @PostMapping("/task4")
    public String task4(@RequestBody String s){
        JSONObject jo = new JSONObject(s);
        executorService.execute(new ThreadFour(jo,taskFour));
        return "task4";
    }
}
