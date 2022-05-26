package com.hotel.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AMQPConfiguration {

	// Using RabbitMQ
	public static final String QUEUE = "invoice_queue";
	public static final String EXCHANGE = "invoice_exchange";
	public static final String ROUTING_KEY = "invoice_routingKey";
	
	@Bean
	//creating Queue
	public Queue queue()
	{
		return new Queue(QUEUE);
	}
	
	@Bean
	//creating exchange
	public TopicExchange exchange()
	{
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	//creating Routing key
	public Binding binding(Queue queue, TopicExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	
	@Bean
	// MessageConverter is used to convert whole object into JSON format and send to particle  queue for that MessageConverter is used
	public MessageConverter converter()
	{
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory)
	{
		final RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(converter());
		return template;
	}
}