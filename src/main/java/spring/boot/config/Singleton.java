package spring.boot.config;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.boot.RejectedExecutionHandlerImpl;

import java.util.concurrent.*;

@Configuration
public class Singleton {
    private MongoClient mongoClient = null;
    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private  int port;
    @Bean
    public   MongoClient getInstance()
    {
        if (mongoClient == null){
            mongoClient = new MongoClient(host,port);
            return mongoClient;
        }
        return mongoClient;
    }
    @Bean
    public  MongoCollection<Document> getCollection(){
        MongoClient mongo =getInstance();
        MongoDatabase database = mongo.getDatabase("HallBookings");
        MongoCollection<Document> collection = database.getCollection("Bookings");
        return collection;
    }
    @Bean(name="server")
    public ExecutorService getExecutorServer(){
        ExecutorService executor = Executors.newFixedThreadPool(100);
        return executor;
    }
    @Bean(name="client")
    public ExecutorService getExecutorClient(){
        ExecutorService executor = Executors.newFixedThreadPool(100);
        return executor;
    }
//    @Bean
//    public ThreadPoolExecutor getThreadPoolExecutor() {
//        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), rejectionHandler);
//        return threadPoolExecutor;
//    }
}