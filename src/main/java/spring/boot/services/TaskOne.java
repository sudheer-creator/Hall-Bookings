package spring.boot.services;
import java.text.ParseException;
import java.util.ArrayList;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.json.JSONException;
import org.json.JSONObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import spring.boot.model.Hall;
import spring.boot.exceptionhandling.Input;
import java.util.Iterator;
import static com.mongodb.client.model.Filters.*;

@Service
public class TaskOne{
    @Autowired
    private Hall h;
    @Autowired
    MongoCollection<Document> collection;
    public ArrayList<String> helper1(String inputSd, String inputEd, int capacity)  {
        ArrayList<String> list = new ArrayList<>();

        ArrayList<Hall> halls = h.getHall();
        for (Hall h : halls) {
            if (h.capacity >= capacity) list.add(h.hallName);
        }
        // Query Selector
        FindIterable<Document> iterable = collection.find(
                or
                        (
                                and
                                        (
                                                gte("startDate",inputSd), lte("endDate",inputEd)
                                        ),
                                and
                                        (
                                                lt("startDate",inputSd), gt("endDate",inputSd)
                                        ),
                                and
                                        (
                                                gt("endDate",inputEd), lt("startDate",inputEd)
                                        )
                        )
        );
        Iterator<Document>it  = iterable.iterator();
        while (it.hasNext()) {
            Document d = it.next();
            String hallName = (String)d.get("hallName");
            list.remove(hallName);
        }
        return list;
    }
    public String one(JSONObject jo) throws ParseException, JSONException {
        String inputSd = jo.getString("startDate");
        String inputEd =jo.getString("endDate");
        int capacity =jo.getInt("capacity");
        String check = Input.checkInputTaskOne(inputSd,inputEd,capacity);
        if(check==""){
            ArrayList<String> list = helper1(inputSd, inputEd, capacity);
            JSONObject res = new JSONObject();
            res.put("startDate", inputSd);
            res.put("endDate", inputEd);
            res.put("capacity", capacity);
            res.put("availableHalls", list);
            return res.toString();
        }
        else{
            return check;
        }
    }
}
