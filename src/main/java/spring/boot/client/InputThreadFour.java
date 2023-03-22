package spring.boot.client;

import org.json.JSONObject;
import spring.boot.utilities.Utility;

import java.util.ArrayList;

public class InputThreadFour implements Runnable{
    Utility u = new Utility();
    JSONObject jo;
    public InputThreadFour(JSONObject jo){
        this.jo = jo;
    }
    @Override
    public void run() {
        ArrayList<String> targetURL = u.getTargetURL();
        u.executePost(targetURL.get(3), jo.toString());
    }
}
