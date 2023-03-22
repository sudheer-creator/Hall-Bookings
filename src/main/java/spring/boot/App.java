package spring.boot;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import spring.boot.client.InputThreadFour;
import spring.boot.client.InputThreadOne;
import spring.boot.client.InputThreadThree;
import spring.boot.client.InputThreadTwo;

import java.io.InputStream;

@SpringBootApplication
public class App implements CommandLineRunner{
	@Autowired
	@Qualifier("client")
	ExecutorService executorService;
	public  static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App run started");
		String resourceName = "src/main/java/spring/boot/file.json";
		String content = new String(Files.readAllBytes(Paths.get(resourceName)));
		JSONObject jsonObject = new JSONObject(content);
		JSONArray ja  = jsonObject.getJSONArray("input");
		for(int i=0;i<ja.length();i++){
			JSONObject curr = (JSONObject)ja.get(i);
			try{
				JSONObject task1 = curr.getJSONObject("task1");
				executorService.execute(new InputThreadOne(task1));
			}
			catch(Exception e){}
			try {
				JSONObject task2 = curr.getJSONObject("task2");
				executorService.execute(new InputThreadTwo(task2));
			}
			catch (Exception e){}

			try{
				JSONObject task3= curr.getJSONObject("task3");
				executorService.execute(new InputThreadThree(task3));
			}
			catch (Exception e){}
			try{
				JSONObject task4= curr.getJSONObject("task4");
				executorService.execute(new InputThreadFour(task4));
			}
			catch (Exception e){}
		}

	}
}
