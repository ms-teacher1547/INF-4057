package com.m1fonda.service_notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;



@Configuration
@EnableRabbit
public class RabbitConfig {
    // Creer un convertisseur du message pour gerer la serialization et la deserialization
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
            return new Jackson2JsonMessageConverter();
        
    }

    // Configuration de RabbitTemple pour utiliser le convertisseur 
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(jsonMessageConverter());

        return rabbitTemplate;
    }

    @Bean
    public FanoutExchange userExchange() {
        return new FanoutExchange("userExchange");
    }

    @Bean
    public Queue userNotificationQueue() {
        return new Queue("userNotificationQueue", true);
    }

    @Bean
    public Binding bindingUserNotificationQueue(Queue userNotificationQueue, FanoutExchange userExchange) {
        return BindingBuilder.bind(userNotificationQueue).to(userExchange);
    }
}
