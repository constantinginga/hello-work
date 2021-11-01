package work.hello.Tier3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.reactive.function.client.WebClient;
import work.hello.Tier3.Model.Model;
import work.hello.Tier3.Model.ModelManager;

@SpringBootApplication
public class Tier3Application {
private static Model model;
	public static void main(String[] args) {
		 model = new ModelManager();
		SpringApplication.run(Tier3Application.class, args);
	}

	public static Model getModel()
	{
		return model;
	}
}
