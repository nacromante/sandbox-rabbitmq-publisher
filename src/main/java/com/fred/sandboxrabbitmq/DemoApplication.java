package com.fred.sandboxrabbitmq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Value("${rabbitmq.queue.name}")
	private String queueName;
	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	@Value("${rabbitmq.key.name}")
	private String keyName;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Queue queue(){
		return new Queue(queueName, true);
	}
	@Bean
	public DirectExchange exchange(){
		return new DirectExchange(exchangeName);
	}
	@Bean
	public Binding binding(Queue queue, DirectExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(keyName);
	}

}
