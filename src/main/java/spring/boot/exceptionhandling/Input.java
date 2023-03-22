package spring.boot.exceptionhandling;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Input {
    public static boolean dateChecker(String inputSd, String inputEd){
        boolean flag = true;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            Date sd = formatter.parse(inputSd);
        } catch (ParseException e) {
            flag = false;
        }
        try {
            Date ed = formatter.parse(inputEd);
        } catch (ParseException e) {
            flag = false;
        }
        return flag;
    }
    public static boolean checkHallName(String name){
        ArrayList<String> list = new ArrayList<>();
        list.add("Hall A");
        list.add("Hall B");
        list.add("Hall C");
        list.add("Hall D");
        list.add("Hall E");
        list.add("Hall F");
        if(list.contains(name)==true){
            return true;
        }
        return false;
    }
    public static String checkInputTaskOne(String inputSd,String inputEd, int capacity){
        String res ="";
        if(dateChecker(inputSd,inputEd)==false){
            res+= "Date format is invalid";
        }
        return res;
    }
    public static String checkInputTaskTwo(String inputSd,String inputEd,int capacity, String hallName){
        String res ="";
        if(dateChecker(inputSd,inputEd)==false){
            res+= "Date format is invalid";
        }
        if(checkHallName(hallName)==false){
            res+=" Hall Name is Incorrect";
        }
        return res;
    }
    public static String checkInputTaskThree(String inputSd, String inputEd){
        String res ="";
        if(dateChecker(inputSd,inputEd)==false){
            res+= "Date format is invalid";
        }
        return res;
    }
}
