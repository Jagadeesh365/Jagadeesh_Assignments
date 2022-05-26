package com.hotel.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Model.Invoice;
import com.hotel.Model.Show;
import com.hotel.config.AMQPConfiguration;

@Service
public class InvoiceService {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public Show displayInvoice(Invoice invoice)
	{
		rabbitTemplate.convertAndSend(AMQPConfiguration.EXCHANGE, AMQPConfiguration.ROUTING_KEY, invoice);
		return new Show("Sending Invoice to Queue - ", "Successfull");
	}
}
