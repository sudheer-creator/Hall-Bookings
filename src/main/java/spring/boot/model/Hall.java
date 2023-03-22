package spring.boot.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class Hall {
    public int capacity;
    public String hallName;
    public Hall(){

    }
    public Hall(int capacity, String hallName) {
        this.capacity = capacity;
        this.hallName = hallName;
    }
    public  ArrayList<Hall> getHall(){
        ArrayList<Hall> list = new ArrayList<>();
        Hall A = new Hall(50,"Hall A");
        Hall B = new Hall(100,"Hall B");
        Hall C = new Hall(200,"Hall C");
        Hall D = new Hall(350,"Hall D");
        Hall E = new Hall(500,"Hall E");
        Hall F = new Hall(1000,"Hall F");
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);
        list.add(E);
        list.add(F);
        return list;
    }
}
