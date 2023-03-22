package spring.boot.services;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.exceptionhandling.InvalidBooking;

@Service
public class TaskFour {
    @Autowired
    TaskTwo obj;
    public String four(JSONObject jsonObject) throws JSONException,InvalidBooking {
        String res ="";
        JSONArray ja = (JSONArray)jsonObject.get("bookings");
        for(int i=0;i<ja.length();i++){
            JSONObject jo = ja.getJSONObject(i);
            try{
                res+= obj.two(jo);
            }
            catch (Exception e){
                 res+=e.getMessage();
            }
            res+="\n";
        }
        return res;
    }
}

