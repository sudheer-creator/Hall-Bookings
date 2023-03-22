package spring.boot.client;

import org.json.JSONObject;
import spring.boot.utilities.Utility;

import java.util.ArrayList;

public class InputThreadTwo implements Runnable{
    JSONObject jo;
    public InputThreadTwo(JSONObject jo){
        this.jo = jo;
    }
    Utility u = new Utility();
    @Override
    public void run() {
        ArrayList<String> targetURL = u.getTargetURL();
        u.executePost(targetURL.get(1), jo.toString());
    }
}
