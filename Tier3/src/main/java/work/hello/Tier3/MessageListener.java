package work.hello.Tier3;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import work.hello.Tier3.Model.Application;
import work.hello.Tier3.Model.CustomMessage;
import work.hello.Tier3.Model.Model;

@Component public class MessageListener
{
  @Autowired private RabbitTemplate template;
  private Model model;
  private Gson gson;

  public MessageListener(RabbitTemplate template)
  {
    this.template = template;
    this.model = Tier3Application.getModel();
    gson = new Gson();
  }

  @RabbitListener(queues = MQConfig.CALLBACK_QUEUE) public void listener(
      CustomMessage message)
  {
    System.out.println("recieved");

    model = Tier3Application.getModel();
    switch (message.getType())
    {
      case getAllJobListings:
        message.setContent(gson.toJson(model.getJobListings()));
        template
            .convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
        break;
      case applyForJob:
        System.out.println(message.getContent() + "here");
        Application application = gson
            .fromJson(message.getContent(), Application.class);
        model.applyJobListing(application);

    }

  }

}