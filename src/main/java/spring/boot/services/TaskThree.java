package spring.boot.services;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.exceptionhandling.Input;
import java.util.Iterator;
import static com.mongodb.client.model.Filters.*;
@Service
public class TaskThree {
    @Autowired
    MongoCollection<Document> collection;
    public  JSONArray helper1(String inputSd, String inputEd) throws JSONException {
        JSONArray ja = new JSONArray();
        FindIterable<Document> iterable = collection.find(
                and
                        (
                                gte("startDate",inputSd), lte("endDate",inputEd)
                        )
        );
        Iterator<Document>it  = iterable.iterator();
        while (it.hasNext()) {
            JSONObject jo = new JSONObject();
            Document d = it.next();
            String hallName = (String)d.get("hallName");
            String startDate = (String)d.get("startDate");
            String endDate = (String)d.get("endDate");
            int capacity = (int)d.get("capacity");
            jo.put("startDate",startDate);
            jo.put("endDate",endDate);
            jo.put("capacity",capacity);
            jo.put("hallName",hallName);
            ja.put(jo);
        }
        return ja;
    }
    public  String three(JSONObject jo) throws  JSONException {
        String inputSd = jo.getString("startDate");
        String inputEd = jo.getString("endDate");
        String check = Input.checkInputTaskThree(inputSd,inputEd);
        if(check==""){
            JSONArray ans = helper1(inputSd, inputEd);
            return ans.toString();
        }
        else{
            return check;
        }
    }
}
