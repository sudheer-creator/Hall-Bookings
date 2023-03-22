package spring.boot.client;

import org.json.JSONObject;
import spring.boot.utilities.Utility;

import java.util.ArrayList;

public class InputThreadOne implements Runnable {
    JSONObject jo;
    public InputThreadOne(JSONObject jo){
        this.jo = jo;
    }
    Utility u = new Utility();
    @Override
    public void run() {
        ArrayList<String> targetURL = u.getTargetURL();
        u.executePost(targetURL.get(0),jo.toString());

    }
}
