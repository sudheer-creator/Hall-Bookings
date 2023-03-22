package spring.boot.client;

import org.json.JSONObject;
import spring.boot.utilities.Utility;

import java.util.ArrayList;

public class InputThreadThree implements Runnable{
    Utility u = new Utility();
    JSONObject jo;
    public InputThreadThree(JSONObject jo){
        this.jo = jo;
    }
    @Override
    public void run() {
        ArrayList<String> targetURL = u.getTargetURL();
        u.executePost(targetURL.get(2), jo.toString());

    }
}
