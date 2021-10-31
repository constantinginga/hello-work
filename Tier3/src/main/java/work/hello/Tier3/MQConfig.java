package work.hello.Tier3;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String QUEUE = "message_queue";
    public static final String CALLBACK_QUEUE = "callback_queue";
    public static final String EXCHANGE = "message_exchange";
    public static final String ROUTING_KEY = "message_routingKey";
    public static final String ROUTING_KEYB = "message_routingKey";

    @Bean
    public Queue queueA() {
        return  new Queue(QUEUE);
    }
    @Bean
    public Queue queueB() {
        return  new Queue(CALLBACK_QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingA(Queue queueA, TopicExchange exchange) {
        return BindingBuilder
                .bind(queueA)
                .to(exchange)
                .with(ROUTING_KEY);
    }
    @Bean
    public Binding bindingB(Queue queueB, TopicExchange exchange) {
        return BindingBuilder
                .bind(queueB)
                .to(exchange)
                .with(ROUTING_KEYB);
    }

    @Bean
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }

}
