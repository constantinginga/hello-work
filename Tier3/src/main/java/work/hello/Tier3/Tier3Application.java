package work.hello.Tier3;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Tier3Application {

	public static void main(String[] args) {

		WebClient client = WebClient.create("http://localhost:9000");

		SpringApplication.run(Tier3Application.class, args);
	}
}
