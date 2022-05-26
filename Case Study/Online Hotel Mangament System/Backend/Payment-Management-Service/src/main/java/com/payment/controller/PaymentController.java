package com.payment.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.eshoppingzone.paymentservice.entities.MyOrder;
//import com.eshoppingzone.paymentservice.repository.PaymentRepository;
//import com.eshoppingzone.paymentservice.services.SequenceGeneratorService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@CrossOrigin
public class PaymentController {
	

	
	private final static Logger Logger = LoggerFactory.getLogger(PaymentController.class);
	
	@PostMapping("/create_order/{amount}")
	public String createOrder(@PathVariable double amount) throws RazorpayException 
	{
		
		var client = new RazorpayClient("rzp_test_88Fw6jzdPSitWF", "PFP45CWmvehcnpXjoOefnDtr");
		
		JSONObject ob = new JSONObject();
		ob.put("amount", amount*100);
		ob.put("currency", "INR");
		ob.put("receipt", "txn_235425");
		
		// creating new order
		
		Order order = client.Orders.create(ob);
		Logger.info(order.toString());
		System.out.println(order);
		

		return order.toString();
	}
	


}
