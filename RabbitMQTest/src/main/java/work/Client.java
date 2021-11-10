package work;

import model.RabbitMQ;
import model.data.Application;
import model.data.JobListing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication public class Client
{
    public static int  deleteLater = 1;
    public static void main(String[] args)
    {
        SpringApplication.run(Client.class, args);
        Scanner s = new Scanner(System.in);
        while(true)

        {
            System.out.println("choose option");
            System.out.println("1) create joblisting");
            System.out.println("2) apply for job");
            int x = s.nextInt();

            switch(x) {
                case 1:
                    RabbitMQ.getInstance().createJobListing(new JobListing(1,"ok"));
                    break;
                case 2:
                    System.out.println(RabbitMQ.getInstance().getJobListings());
                    break;

            }
        }
    }
}
