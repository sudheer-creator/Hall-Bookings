package spring.boot.services;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.exceptionhandling.Input;
import spring.boot.exceptionhandling.InvalidBooking;

import java.util.ArrayList;
@Service
public class TaskTwo {
    @Autowired
    MongoCollection<Document> collection;
    @Autowired
    TaskOne obj;
    public   String two(JSONObject jo) throws JSONException, InvalidBooking {
        String inputSd = (String) jo.get("startDate");
        String inputEd = (String) jo.get("endDate");
        int capacity = (int) jo.get("capacity");
        String hallName = (String) jo.get("hallName");
        String check = Input.checkInputTaskTwo(inputSd,inputEd,capacity,hallName);
        String res ="";
        if(check==""){
            ArrayList<String> list = obj.helper1(inputSd, inputEd, capacity);
            if (list.contains(hallName) == true) {
                Document document = new Document();
                document.append("startDate", inputSd);
                document.append("endDate", inputEd);
                document.append("capacity", capacity);
                document.append("hallName", hallName);
                collection.insertOne(document);
                res += hallName + " is inserted successfully";
            }
            else {
                res+="Invalid Booking";
                throw new InvalidBooking("Invalid Booking");
            }
            return res;
        }
        return check;
    }
}

