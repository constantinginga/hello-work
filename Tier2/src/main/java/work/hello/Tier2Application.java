package work.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication public class Tier2Application
{
  public static int  deleteLater = 1;

  public static void main(String[] args)
  {
    int i = 2;
    SpringApplication.run(Tier2Application.class, args);
  }

}
